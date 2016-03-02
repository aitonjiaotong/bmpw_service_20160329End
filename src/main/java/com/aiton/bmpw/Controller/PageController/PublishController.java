package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 上午11:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class PublishController {
    @RequestMapping("/publish")
    public String execute(){
        return "Publish";
    }
}
