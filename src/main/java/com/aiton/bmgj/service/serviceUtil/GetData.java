package com.aiton.bmgj.service.serviceUtil;



import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;
import ytx.org.apache.http.*;
import ytx.org.apache.http.client.HttpClient;
import ytx.org.apache.http.client.methods.HttpPost;
import ytx.org.apache.http.conn.ClientConnectionManager;
import ytx.org.apache.http.conn.scheme.Scheme;
import ytx.org.apache.http.conn.scheme.SchemeRegistry;
import ytx.org.apache.http.conn.ssl.SSLSocketFactory;
import ytx.org.apache.http.entity.StringEntity;
import ytx.org.apache.http.impl.client.DefaultHttpClient;
import ytx.org.apache.http.impl.conn.PoolingClientConnectionManager;
import ytx.org.apache.http.message.BasicHeader;
import ytx.org.apache.http.protocol.HTTP;
import ytx.org.apache.http.util.EntityUtils;


import javax.net.ssl.SSLContext;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 从服务器获取原始数据
 * Created by user on 2016/3/3.
 */
@Component("getData")
public class GetData {

      /*
       *静态数据接口    218.5.80.24 3061
       *  实时数据接口    218.5.80.18 6607
       *  用户：test_ty  密码：1234
       *        test_at       1234
       *  线路信息：https://{部署地址}/api/Busline/Get
       *
       *
       *  另外的账号和接口
       *  https://218.5.80.19:9110/";
       * "gps_sgapi";
       * "sgapi";
       *
       *
       */

    private static final String username = "test_at";
    private static final String password = "1234";


    //private static final String username = "gps_sgapi";
    //private static final String password = "sgapi";
    //private static final String getBusLine_url = "https://218.5.80.19:9110/api/Busline/Get";


    private static final String getBusLine_url = "https://218.5.80.24:3061/api/Busline/Get";
    private static final String getStation_url = "https://218.5.80.24:3061/api/Station/GetLineStation";
    private static final String getBus_url = "https://218.5.80.24:3061/api/Car/Get";
    private static final String getDriver_url = "https://218.5.80.24:3061/api/Driver/Get";
    private static final String getPlanRunTime_url = "https://218.5.80.24:3061/api/run/GetPlanRunTime";
    private static final String getDriverWorkTime_url = "https://218.5.80.24:3061/api/run/GetDriverWorkTime";
    private static final String getLastGpsData_url = "https://218.5.80.24:3061/api/run/GetLastGpsData";
    private static final String getStationBase_url = "https://218.5.80.24:3061/api/Station/GetStation";



    /**获取公交线路数据
     * 返回json字符串
     * */
    public String getBusLine(){
        return getData(getBusLine_url,null);
    }

    /**获取站点数据
     * 返回json字符串
     * */
    public String getStation(){
        return getData(getStation_url,null);
    }

    /**获取公交车辆数据
     * 返回json字符串
     * */
    public String getBus(){
        return getData(getBus_url,null);
    }

    /**获取驾驶员数据
     * 返回json字符串
     */
    public String getDriver(){
        return getData(getDriver_url,null);
    }

    /**获取发车计划数据
     * 返回json字符串
     */
    public String getPlanRunTime(Date date) throws UnsupportedEncodingException {
        /*参数格式：{“run_date”:”2015-12-14”}*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datestr = sdf.format(date);
        //{"run_date":"2016-03-07"}
      //  datestr = "{\"run_date\":\""+ datestr +"\"}";
      //  datestr = "{\"run_date\":\"2016-3-8\"}";
      //  System.out.println(datestr);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("run_date","2016-03-07");
        String ss = jsonObject.toString();
        StringEntity stringEntity = new StringEntity(ss,"utf-8");
        System.out.println(ss);
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding("utf-8");
        return getData(getPlanRunTime_url,stringEntity);
    }

    /**获取驾驶员考勤数据
     * 返回json字符串
     */
    public String getDriverWorkTime(){
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(new Date());
        s = "{\"run_time\":\""+ s +"\"}";
        System.out.println(s);
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(s,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("run_date","2016-03-08");
        StringEntity s = null;
        try {
            s = new StringEntity(jsonObject.toString(),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
      //  s.setContentType("application/x-www-form-urlencoded");
        s.setContentEncoding("utf-8");
        s.setContentType("application/json");
        System.out.println(jsonObject.toString());
        return getData(getDriverWorkTime_url,s);
    }

    /**获取最新的GPS数据
     * 返回json字符串
     */
    public String getLastGpsData(){
        return getData(getLastGpsData_url,null);
    }

    /**获取站点基础信息
     * 返回json字符串
     * */
    public String getStationBase(){
        return getData(getStationBase_url,null);
    }



    /**获取所有数据的私有方法
     * 返回：json字符串
     * */
    private  String getData (String url,StringEntity se) {
        String s = null;
        try {
             s = new String((username+":"+password).getBytes(),"utf-8");
             BASE64Encoder encoder = new BASE64Encoder();
             s = encoder.encode(s.getBytes());
             } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
            }
        HttpClient httpClient = new DefaultHttpClient();
        try {
            httpClient = WebClientDevWrapper.wrapClient(httpClient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(url);
        final HttpPost post = new HttpPost(url);
        //                             application/x-www-form-urlencoded
        post.setHeader("Content-Type","application/json");
        post.addHeader("Authorization","Basic "+ s );
        if(se!=null){
            System.out.println("参数对象不为空！现在添加进请求头！！");
            //post.removeHeaders("Content-Type");
            post.setEntity(se);
            try {
                System.out.println("*************************");
                System.out.println(EntityUtils.toString(post.getEntity(), "utf-8"));
                System.out.println(post.getEntity().getContentType().toString());

                System.out.println("*************************");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("参数对象为空！");
        }
        Header[] headers = post.getAllHeaders();
        for(Header h : headers){
            System.out.println("输出 request 的 header:");
            System.out.println(h.toString());
        }
        HttpResponse response = null;
        try {
            response = httpClient.execute(post);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String strResult = null;

        System.out.println("返回的状态码：");
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().toString());
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getLocale());
        Header[] headers1 = response.getAllHeaders();
        for(Header hh : headers1) {
            System.out.println("输出 response 的header:");
            System.out.println(hh.toString());
        }
        try {
            strResult = EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response.getStatusLine().getStatusCode()==200){
            System.out.println("返回正常的结果！请求成功！");
        }

        //System.out.println("返回如下结果：");
       // System.out.println(strResult);

        return strResult;

    }

 }

/**
 * SSL验证包装类，用于包装HttpClient类
 */
class WebClientDevWrapper {

    public static ytx.org.apache.http.client.HttpClient wrapClient(ytx.org.apache.http.client.HttpClient base) throws Exception {
        try {
            SSLContext ctx = SSLContext.getInstance("SSL");
            X509TrustManager tm = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = base.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", 443, ssf));
            PoolingClientConnectionManager pccm = new PoolingClientConnectionManager(sr);
            return new DefaultHttpClient(pccm, base.getParams());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw  ex;
        }
    }
}