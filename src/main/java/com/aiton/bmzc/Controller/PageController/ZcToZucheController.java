package com.aiton.bmzc.controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 租车跳转页面
 * Created by user on 2016/3/19.
 */
@Controller
public class ZcToZucheController {
    @RequestMapping("/toZC_Zuche")
    public String execute(){
        return "zc_zuche";
    }
}
