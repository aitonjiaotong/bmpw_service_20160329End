package com.aiton.wxApliy.util;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-22
 * Time: 下午7:20
 * To change this template use File | Settings | File Templates.
 */
public class RamCharsUtil {
    private static final String[] chars={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public static String getRamChars(){
        Random ran=new Random();
        int n=0;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<32;i++){
            n=ran.nextInt(32);
            str.append(chars[n]);
        }
        return str.toString();
    }
}
