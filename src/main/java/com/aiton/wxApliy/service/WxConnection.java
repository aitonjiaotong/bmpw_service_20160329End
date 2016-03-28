package com.aiton.wxApliy.service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-22
 * Time: 下午6:31
 * To change this template use File | Settings | File Templates.
 */


import com.aiton.wxApliy.entity.WxRequest;
import com.aiton.wxApliy.util.MD5Util;
import com.aiton.wxApliy.util.RamCharsUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 往微信提交单
 */
public class WxConnection {
    public String reqOrder(WxRequest request){
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder");
        String xml = getPackage(request);
        StringEntity entity;
        String prepay_id="";
        String result="";
        try {
            entity = new StringEntity(xml, "utf-8");
            httpPost.setEntity(entity);
            HttpResponse httpResponse;
            // post请求
            httpResponse = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                 result= EntityUtils.toString(httpEntity, "UTF-8");
                //System.out.println("返回结果"+result);
                // 过滤
                result = result.replaceAll("<![CDATA[|]]>", "");
                prepay_id= Jsoup.parse(result).select("prepay_id").html();
                //System.out.println("返回值"+result);
                if (prepay_id != null)
                    return prepay_id;
            }
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prepay_id;
    }
    public String getPackage(WxRequest request) {
        SortedMap<String,String>map=new TreeMap<String, String>();
        map.put("appid",request.getAppid());
        map.put("mch_id",String.valueOf(1324165801));
        map.put("nonce_str", RamCharsUtil.getRamChars());//随机字符串
        map.put("body",request.getBody());//商品描述
        map.put("out_trade_no",request.getOut_trade_no());//商户订单号
        map.put("total_fee",String.valueOf(request.getTotal_fee()));//总金额
        map.put("spbill_create_ip",request.getSpbill_create_ip());//用户端IP
        map.put("notify_url",request.getNotify_url());//通知地址
        map.put("trade_type",request.getTrade_type());//支付类型
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key).append("=").append(map.get(key)).append("&");
        }
        sb.append("key=" + "o7q16VNoBB7ABPpSHB6dAL0LHAMCYdUp");
        String sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
        map.put("sign", sign);

        StringBuilder xml = new StringBuilder();
        xml.append("<xml>\n");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ("body".equals(entry.getKey()) || "sign".equals(entry.getKey())) {
                xml.append("<" + entry.getKey() + "><![CDATA[").append(entry.getValue()).append("]]></" + entry.getKey() + ">\n");
            } else {
                xml.append("<" + entry.getKey() + ">").append(entry.getValue()).append("</" + entry.getKey() + ">\n");
            }
        }
        xml.append("</xml>");
        //System.out.println("发送给腾讯的数据："+xml.toString());
        return xml.toString();
    }
}
