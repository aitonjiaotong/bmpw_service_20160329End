package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {
    @RequestMapping("/home")
    public String execute(){
        return "home";
    }
}
