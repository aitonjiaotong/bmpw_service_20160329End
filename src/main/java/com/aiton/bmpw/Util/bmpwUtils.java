package com.aiton.bmpw.util;

import com.aiton.bmpw.entity.show.Zone_Web;
import com.aiton.bmpw.entity.Zone;
import com.cloopen.rest.sdk.CCPRestSDK;
import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Account: Administrator
 * Date: 16-2-4
 * Time: 上午8:44
 * To change this template use File | Settings | File Templates.
 */
public class bmpwUtils {
    /**
     * 密码加密工具
     * @param str
     * @return
     */
    public static String StringMD5(String str){
        String s=null;
        try {
            MessageDigest digest=MessageDigest.getInstance("MD5");
            byte[]output=digest.digest(str.getBytes());
            s= Base64.encodeBase64String(output);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return s;
    }
    //发送短信工具
    public static void sendMessage(String phone){
        HashMap result=null;
        CCPRestSDK restAPI = new CCPRestSDK();
        restAPI.init("sandboxapp.cloopen.com", "8883");
        restAPI.setAccount("8a48b55152a56fc20152e7dc378e46de", "3fe0aa8a0ffc444c9a245f2afeb8dc9a");
        restAPI.setAppId("aaf98f8952b6f5730152e7dc8e6531a9");
        result = restAPI.sendTemplateSMS(phone,"1" ,new String[]{"模板内容1","模板内容2"});
        System.out.println("SDKTestGetSubAccounts result=" + result);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap data = (HashMap) result.get("data");
            Set keySet = data.keySet();
            for(Object key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
    }
   public static Zone_Web setZonetoZone_Web(Zone zone){
       Zone_Web zone_web=new Zone_Web();
       zone_web.setZoneName(zone.getZoneName());
       zone_web.setFullName(zone.getFullName());
       zone_web.setFullCode(zone.getFullCode());
       zone_web.setParentZoneID(zone.getParentZoneID());
       zone_web.setSubZones(null);
       zone_web.setZoneCode(zone.getZoneCode());
       zone_web.setZoneID(zone.getZoneID());
       return zone_web;
   }

}
