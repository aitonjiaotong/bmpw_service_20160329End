package com.aiton.bmpw.controller.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午10:56
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class toRefundController {
    @RequestMapping("/refunds")
    public String execute(){
        return "refunds";
    }
}
