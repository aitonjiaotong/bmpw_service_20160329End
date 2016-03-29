package com.aiton.bmpw.controller.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ToIndexController {
    @RequestMapping("/index")
    public String execute(){
        return "Index";
    }
}
