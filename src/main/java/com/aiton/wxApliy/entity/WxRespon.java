package com.aiton.wxApliy.entity;

import java.util.SortedMap;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-23
 * Time: 上午11:32
 * To change this template use File | Settings | File Templates.
 */
public class WxRespon {
    private String sign;
    private SortedMap<String,String> map;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public SortedMap<String, String> getMap() {
        return map;
    }

    public void setMap(SortedMap<String, String> map) {
        this.map = map;
    }
}
