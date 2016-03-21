package com.aiton.bmzc.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加实体店页面跳转
 * Created by user on 2016/3/19.
 */
@Controller
public class Zc_AddStoreController {
    @RequestMapping("/toZC_AddStore")
    public String execute(){
        return "zc_addstore";
    }
}
