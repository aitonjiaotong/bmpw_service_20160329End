package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午5:02
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ToUpdateUserPasswordController {
    @RequestMapping("/updatepassword")
    public String execute(){
        return "UpdateUserPassword";
    }
}
