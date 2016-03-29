package com.aiton.bmpw.controller.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 上午11:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class toContextsController {
    @RequestMapping("/contexts")
    public String execute(){
        return "Contexts";
    }
}
