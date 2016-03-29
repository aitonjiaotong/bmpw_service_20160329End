package com.aiton.bmpw.controller.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ToUserController {
    @RequestMapping("/user")
    public String execute(){
        return "gl_users";
    }
}
