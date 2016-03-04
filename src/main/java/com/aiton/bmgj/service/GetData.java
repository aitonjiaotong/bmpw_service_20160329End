package com.aiton.bmgj.service;


import sun.misc.BASE64Encoder;

import ytx.org.apache.http.HttpResponse;
import ytx.org.apache.http.client.HttpClient;
import ytx.org.apache.http.client.methods.HttpPost;
import ytx.org.apache.http.conn.ClientConnectionManager;
import ytx.org.apache.http.conn.scheme.Scheme;
import ytx.org.apache.http.conn.scheme.SchemeRegistry;
import ytx.org.apache.http.conn.ssl.SSLSocketFactory;
import ytx.org.apache.http.impl.client.DefaultHttpClient;
import ytx.org.apache.http.impl.conn.PoolingClientConnectionManager;
import ytx.org.apache.http.util.EntityUtils;


import javax.net.ssl.SSLContext;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


/**
 * 从服务器获取原始数据
 * Created by user on 2016/3/3.
 */
public class GetData {
    private static final String username = "test_ty";
    private static final String password = "1234";

    private static final String getBusLine_url = "https://218.5.80.24:3061/api/Busline/Get";
    private static final String getStation_url = "https://218.5.80.24:3061/api/Station/Get";
    private static final String getBus_url = "https://218.5.80.24:3061/api/Car/Get";
    private static final String getDriver_url = "https://218.5.80.24:3061/api/Driver/Get";
    private static final String getPlanRunTime_url = "https://218.5.80.24:3061/api/run/GetPlanRunTime";
    private static final String getDriverWorkTime_url = "https://218.5.80.24:3061/api/run/GetDriverWorkTime";
    private static final String getLastGpsData_url = "https://218.5.80.24:3061/api/run/GetLastGpsData";

    /**获取公交线路数据
     * 返回json字符串
     * */
    public String getBusLine(){
        return getData(getBusLine_url);
    }

    /**获取站点数据
     * 返回json字符串
     * */
    public String getGetStation(){
        return getData(getStation_url);
    }

    /**获取公交车辆数据
     * 返回json字符串
     * */
    public String getBus(){
        return getData(getBus_url);
    }

    /**获取驾驶员数据
     * 返回json字符串
     */
    public String getDriver(){
        return getData(getDriver_url);
    }

    /**获取发车计划数据
     * 返回json字符串
     */
    public String getPlanRunTime(){
        return getData(getPlanRunTime_url);
    }

    /**获取驾驶员考勤数据
     * 返回json字符串
     */
    public String getDriverWorkTime(){
        return getData(getDriverWorkTime_url);
    }

    /**获取最新的GPS数据
     * 返回json字符串
     */
    public String getLastGpsData(){
        return getData(getLastGpsData_url);
    }

    /**获取所有数据的私有方法
     * 返回：json字符串
     * */
    private  String getData (String url){
        /* 静态数据接口    218.5.80.24 3061
        *  实时数据接口    218.5.80.18 6607
        *  用户：test_ty  密码：1234
        *        test_at       1234
        *  线路信息：https://{部署地址}/api/Busline/Get
        */
        String s = null;
        try {
             s = new String((username+":"+password).getBytes(),"utf-8");
             BASE64Encoder encoder = new BASE64Encoder();
             s = encoder.encode(s.getBytes());
             } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
            }

        HttpClient httpClient = new DefaultHttpClient();
        httpClient = WebClientDevWrapper.wrapClient(httpClient);
        final HttpPost post = new HttpPost(url);
        post.addHeader("Authorization","Basic "+ s );
        HttpResponse response = null;
        try {
            response = httpClient.execute(post);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String strResult = null;
        /*
        System.out.println("返回的状态码：");
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().toString());
        */
        if(response.getStatusLine().getStatusCode()==200){
            try {
                strResult = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*
        System.out.println("返回如下结果：");
        System.out.println(strResult);
        */
        return strResult;

    }

 }

class WebClientDevWrapper {

    public static ytx.org.apache.http.client.HttpClient wrapClient(ytx.org.apache.http.client.HttpClient base) {
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
            return null;
        }
    }
}