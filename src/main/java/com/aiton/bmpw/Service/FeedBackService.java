package com.aiton.bmpw.service;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.entity.FeedBack;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-25
 * Time: 上午9:33
 * To change this template use File | Settings | File Templates.
 */
public interface FeedBackService {
    FeedBack addFeedBack(Integer user_id,String contnet);
    DataTables loadFeedBacks(Integer draw,Integer start,Integer length,HttpServletRequest request);
}
