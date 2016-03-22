package com.aiton.weixinapliy;

import com.aiton.bmpw.Util.bmpwUtils;
import com.aiton.weixinapliy.entity.WeixinapliyRequest;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-22
 * Time: 上午10:39
 * To change this template use File | Settings | File Templates.
 */
public class ApliyUtil {
    private static final String[] chars={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public static StringBuffer RandomString(){
        StringBuffer str=new StringBuffer();
        Random ran=new Random();
        for(int i=0;i<32;i++){
            int n=ran.nextInt(36);
            str.append(chars[n]);
        }
        return str;
    }
    public static String getSign(WeixinapliyRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        SortedMap<String,Object>map=new TreeMap<String, Object>();
        map.put("appid",request.getAppid());
        map.put("body",request.getBody());
        map.put("mch_id",request.getMch_id());
        map.put("nonce_str",request.getNonce_str());
        map.put("notify_url",request.getNotify_url());
        map.put("out_trade_no",request.getOut_trade_no());
        map.put("spbill_create_ip",request.getSpbill_create_ip());
        map.put("total_fee",request.getTotal_fee());
        map.put("trade_type",request.getTrade_type());
        String str=map.toString();
        str=str.replaceAll(", ","&");
        str=str.substring(1,str.length()-1);
        str=str+"&key=o7q16VNoBB7ABPpSHB6dAL0LHAMCYdUp";
        str=GetMD5Code(str);
        return str;
    }
    // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
}
