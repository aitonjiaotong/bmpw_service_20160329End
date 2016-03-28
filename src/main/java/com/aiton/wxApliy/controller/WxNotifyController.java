package com.aiton.wxApliy.controller;

import com.aiton.wxApliy.dao.WxResultRepository;
import com.aiton.wxApliy.entity.WXOrderQuery;
import com.aiton.wxApliy.entity.WxPayResults;
import com.aiton.wxApliy.util.XMLUtil;
import org.jdom2.JDOMException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-23
 * Time: 上午9:21
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WxNotifyController {
    @Resource
    private WxResultRepository wxResultRepository;
    @RequestMapping("/wx/notify")
    public void notice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //System.out.println("notify方法");
//        PrintWriter out = response.getWriter();
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        String result = new String(outSteam.toByteArray(), "utf-8");
        //System.out.println("oo:"+result);
        Map<String, String> map = null;
        try {
            map = XMLUtil.doXMLParse(result);
        } catch (JDOMException e) {
            e.printStackTrace();
        }

//        ServletContext context=request.getServletContext();
//        String str=context.getRealPath("/");
//        String savepath=str+"WEB-INF"+File.separator+"pages"+File.separator+"cars"+File.separator+"o.txt";
//        File file=new File(savepath);
//        if(!file.exists()){
//            file.createNewFile();
//        }
//        PrintWriter pw=new PrintWriter(new FileWriter(file));
//        pw.println("接收到的数据"+map.toString());
//        pw.flush();
//        pw.close();
        //System.out.println("map:"+map.toString());
        WXOrderQuery orderQuery = new WXOrderQuery();
        orderQuery.setAppid(map.get("appid"));
        orderQuery.setMch_id(map.get("mch_id"));
        orderQuery.setTransaction_id(map.get("transaction_id"));
        orderQuery.setOut_trade_no(map.get("out_trade_no"));
        orderQuery.setNonce_str(map.get("nonce_str"));
        orderQuery.setPartnerKey("o7q16VNoBB7ABPpSHB6dAL0LHAMCYdUp");
        Map<String, String> orderMap = orderQuery.reqOrderquery();
        //System.out.println("orderMap:"+orderMap.toString());
        if (orderMap.get("return_code") != null && orderMap.get("return_code").equalsIgnoreCase("SUCCESS")) {
            if (orderMap.get("trade_state") != null && orderMap.get("trade_state").equalsIgnoreCase("SUCCESS")) {
                String total_fee = map.get("total_fee");
                String order_total_fee = orderMap.get("total_fee");
                if (Integer.parseInt(order_total_fee) >= Integer.parseInt(total_fee)) {
                    //System.out.println("支付成功");
                    //System.out.println("返回数据为"+orderMap.toString());
                    WxPayResults results=new WxPayResults();
                    results.setSign(orderMap.get("sign"));
                    results.setAppid(orderMap.get("appid"));
                    results.setAttach(orderMap.get("attach"));
                    results.setBank_type(orderMap.get("bank_type"));
                    results.setDevice_info(orderMap.get("device_info"));
                    results.setFee_type(orderMap.get("fee_type"));
                    results.setIs_subscribe(orderMap.get("is_subscribe"));
                    results.setMch_id(orderMap.get("mch_id"));
                    results.setNonce_str(orderMap.get("nonce_str"));
                    results.setOpenid(orderMap.get("openid"));
                    results.setOut_trade_no(orderMap.get("out_trade_no"));
                    results.setResult_code(orderMap.get("result_code"));
                    results.setReturn_msg(orderMap.get("return_msg"));
                    results.setTime_end(Long.valueOf(orderMap.get("time_end")));
                    results.setReturn_code(orderMap.get("return_code"));
                    results.setTotal_fee(Integer.valueOf(orderMap.get("total_fee")));
                    results.setTrade_state(orderMap.get("trade_state"));
                    results.setTrade_type(orderMap.get("trade_type"));
                    results.setTransaction_id(orderMap.get("transaction_id"));
                    wxResultRepository.saveAndFlush(results);
                }
            }
        }else{
            //System.out.println("支付失败");
        }
        //System.out.println(orderMap.toString());
    }
}
