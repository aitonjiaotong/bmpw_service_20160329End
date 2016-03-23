package com.aiton.wxApliy.controller;

import com.aiton.wxApliy.entity.WxRequest;
import com.aiton.wxApliy.service.WxConnection;
import com.aiton.wxApliy.util.MD5Util;
import com.aiton.wxApliy.util.OrderUtil;
import com.aiton.wxApliy.util.RamCharsUtil;
import com.aiton.wxApliy.util.XMLUtil;
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
    public String execute(WxRequest request) throws JDOMException, IOException {
        request.setNotify_url("http://61.154.229.156:8080/bmpw/wx/notify");
        WxConnection wxConnection=new WxConnection();
        String result=wxConnection.reqOrder(request);
        System.out.println("结果为"+result);
        Map<String,String> map=XMLUtil.doXMLParse(result);
        String prepay_id=map.get("prepay_id");
        SortedMap<String,String>sortedMap=new TreeMap<String, String>();
        sortedMap.put("prepay_id",prepay_id);
        sortedMap.put("appId",request.getAppid());
        sortedMap.put("partnerId",String .valueOf(1324165801));
        sortedMap.put("nonceStr", RamCharsUtil.getRamChars());
        sortedMap.put("timeStamp", OrderUtil.GetTimestamp());
        sortedMap.put("package","Sign=WXPay");
        StringBuilder sb=new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key).append("=").append(map.get(key)).append("&");
        }
        String str=sb.substring(0,sb.length()-1);
        str= MD5Util.MD5Encode(str, "utf-8").toUpperCase();
        return str;
    }
}
