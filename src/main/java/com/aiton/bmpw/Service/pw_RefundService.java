package com.aiton.bmpw.service;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.entity.Pw_Refund;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午8:49
 * To change this template use File | Settings | File Templates.
 */
public interface pw_RefundService {
    Pw_Refund addRedfund(Pw_Refund refund);
    Pw_Refund updateRedfund(String bookLogAID);
    DataTables loadRefunds(Integer draw,Integer start,Integer length,HttpServletRequest request);
}
