package com.aiton.bmpw.service.impl;

import com.aiton.bmpw.dao.AccountReponstory;
import com.aiton.bmpw.dao.FeedBackReponstroy;
import com.aiton.bmpw.entity.Account;
import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.entity.FeedBack;
import com.aiton.bmpw.service.FeedBackService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-25
 * Time: 上午9:39
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FeedBackServiceImpl implements FeedBackService{
    @Resource
    private FeedBackReponstroy feedBackReponstroy;
    @Resource
    private AccountReponstory accountReponstory;
    @Override
    public FeedBack addFeedBack(Integer user_id, String contnet) {
        FeedBack feedBack=new FeedBack();
        feedBack.setAccount_id(user_id);
        Account account=accountReponstory.findOne(user_id);
        feedBack.setPhone(account.getPhone());
        feedBack.setDate(new Timestamp(System.currentTimeMillis()));
        feedBack.setContent(contnet);
        feedBack=feedBackReponstroy.saveAndFlush(feedBack);
        account=null;
        return feedBack;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DataTables loadFeedBacks(Integer draw, Integer start, Integer length,HttpServletRequest request) {
        String search=request.getParameter("search[value]");
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        dataTables.setRecordsTotal(feedBackReponstroy.count());
        Integer page=start/length;
        List<FeedBack> feedBacks=new ArrayList<FeedBack>();
        if(search==""){
            dataTables.setRecordsFiltered(feedBackReponstroy.count());
            feedBacks=feedBackReponstroy.findAll(new PageRequest(page,length,new Sort(Sort.Direction.DESC,"date"))).getContent();
        }else{
            search="%"+search+"%";
            dataTables.setRecordsFiltered(Long.valueOf(feedBackReponstroy.countFeedBackByPhoneLike(search).toString()));
            feedBacks=feedBackReponstroy.findFeedBackByPhoneLike(search,new PageRequest(page,length,new Sort(Sort.Direction.DESC,"date"))).getContent();
        }

        dataTables.setData(feedBacks);
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
