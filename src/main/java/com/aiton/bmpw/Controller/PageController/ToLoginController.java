package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午9:49
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ToLoginController {
    @RequestMapping("/toLogin")
    public String execute(){
        return "Login";
    }
}
