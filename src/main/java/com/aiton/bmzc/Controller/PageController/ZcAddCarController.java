package com.aiton.bmzc.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 增加车辆页面跳转
 * Created by user on 2016/3/19.
 */
@Controller
public class ZcAddCarController {
    @RequestMapping("/toZC_AddCar")
    public String execute(){
        return "zc_addcar";
    }
}
