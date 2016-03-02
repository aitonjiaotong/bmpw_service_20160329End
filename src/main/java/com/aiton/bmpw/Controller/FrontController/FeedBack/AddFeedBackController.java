package com.aiton.bmpw.Controller.FrontController.FeedBack;

import com.aiton.bmpw.Entity.FeedBack;
import com.aiton.bmpw.Service.FeedBackService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-25
 * Time: 上午9:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class AddFeedBackController {
    @Resource
    private FeedBackService service;
    @RequestMapping("/front/addfeedback")
    @ResponseBody
    public FeedBack execute(Integer account_id,String content){
         FeedBack feedBack=service.addFeedBack(account_id,content);
        return feedBack;
    }
}
