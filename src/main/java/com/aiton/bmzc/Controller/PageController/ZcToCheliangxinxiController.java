package com.aiton.bmzc.controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-11
 * Time: 下午4:36
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcToCheliangxinxiController {
    @RequestMapping("/toZC_Cheliangxinxi")
    public String execute(){
        return "zc_cheliangxinxi";
    }
}
