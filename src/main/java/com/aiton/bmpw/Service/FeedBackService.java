package com.aiton.bmpw.Service;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Entity.FeedBack;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
