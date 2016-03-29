package com.aiton.bmpw.controller.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-7
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class toPw_OrderController {
    @RequestMapping("/pw_order")
    public String execute(){
       return "pw_order";
    }
}
