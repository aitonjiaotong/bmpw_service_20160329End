package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-1
 * Time: 上午10:22
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ToAddUserController {
    @RequestMapping("/adduser")
    public String execute(){
        return "AddUser";
    }
}
