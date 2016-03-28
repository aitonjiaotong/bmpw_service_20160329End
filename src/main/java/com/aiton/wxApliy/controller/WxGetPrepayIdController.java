package com.aiton.wxApliy.controller;

import com.aiton.wxApliy.entity.WxRequest;
import com.aiton.wxApliy.entity.WxRespon;
import com.aiton.wxApliy.service.WxConnection;
import com.aiton.wxApliy.util.MD5Util;
import com.aiton.wxApliy.util.OrderUtil;
import com.aiton.wxApliy.util.RamCharsUtil;
import com.aiton.wxApliy.util.XMLUtil;
import net.sf.json.JSONObject;
import org.jdom2.JDOMException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-23
 * Time: 上午8:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WxGetPrepayIdController {
    @RequestMapping("/wx/wxpay")
    @ResponseBody
    public WxRespon execute(WxRequest request) throws JDOMException, IOException {
//        request.setNotify_url("http://www.aiton.com.cn:8080/bmpw/wx/notify");
        //System.out.println("ooooooooooooooooooooooooooooooooooooooooo");
        request.setNotify_url("http://www.bmcxfj.com:8080/bmpw/wx/notify");
        JSONObject jsonObject=JSONObject.fromObject(request);
        //System.out.println("接收到的数据:"+jsonObject.toString());
        WxConnection wxConnection=new WxConnection();
        String prepay_id=wxConnection.reqOrder(request);
        //System.out.println("结果为"+prepay_id);
        SortedMap<String,String>sortedMap=new TreeMap<String, String>();
        sortedMap.put("prepayid",prepay_id);
        sortedMap.put("appid",request.getAppid());
        sortedMap.put("partnerid",String .valueOf(1324165801));
        sortedMap.put("noncestr", RamCharsUtil.getRamChars());
        sortedMap.put("timestamp", OrderUtil.GetTimestamp());
        sortedMap.put("package","Sign=WXPay");
        //System.out.println(sortedMap);
        StringBuilder sb=new StringBuilder();
        for (String key : sortedMap.keySet()) {
            //System.out.println(key);
            sb.append(key).append("=").append(sortedMap.get(key)).append("&");
        }
        sb.append("key=" + "o7q16VNoBB7ABPpSHB6dAL0LHAMCYdUp");
        //System.out.println(sb);
        String str= MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
        //System.out.println("返回APP"+str);
        WxRespon wxRespon=new WxRespon();
        wxRespon.setMap(sortedMap);
        wxRespon.setSign(str);
        return wxRespon;
    }
}
