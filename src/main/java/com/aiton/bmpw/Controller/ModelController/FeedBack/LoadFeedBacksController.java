package com.aiton.bmpw.controller.modelController.FeedBack;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.service.FeedBackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoadFeedBacksController {
    @Resource
    private FeedBackService feedBackService;
    @RequestMapping("/feedback/loadfeedbacks")
    @ResponseBody
    public DataTables execute(Integer draw, Integer start, Integer length,HttpServletRequest request){
        DataTables dataTables=feedBackService.loadFeedBacks(draw,start,length,request);
        return dataTables;
    }
}
