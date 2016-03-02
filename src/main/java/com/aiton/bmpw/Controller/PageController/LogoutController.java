package com.aiton.bmpw.Controller.PageController;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午3:28
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LogoutController {
    @RequestMapping("/Logout")
    public String execute(){
        Subject userCurrect= SecurityUtils.getSubject();
        userCurrect.logout();
        return "redirect:/bmpw";
    }
}
