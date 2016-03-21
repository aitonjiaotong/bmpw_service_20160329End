package com.aiton.bmzc.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 租赁方案页面跳转
 * Created by user on 2016/3/19.
 */
@Controller
public class ZcPlansController {
    @RequestMapping("/toZC_Plans")
    public String execute(){
        return "zc_plans";
    }
}
