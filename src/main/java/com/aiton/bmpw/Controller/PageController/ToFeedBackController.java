package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ToFeedBackController {
    @RequestMapping("/feedback")
    public String execute(){
        return "FeedBack";
    }
}
