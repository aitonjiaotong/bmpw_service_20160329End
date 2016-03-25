package com.aiton.bmzc.controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 还车页面跳转
 * Created by user on 2016/3/19.
 */
@Controller
public class ZcToReturnCarController {
    @RequestMapping("/toZC_ReturnCar")
    public String execute(){
        return "zc_returncar";
    }
}
