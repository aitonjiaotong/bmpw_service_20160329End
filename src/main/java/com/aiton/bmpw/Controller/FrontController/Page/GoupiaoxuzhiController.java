package com.aiton.bmpw.Controller.FrontController.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-25
 * Time: 上午9:30
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GoupiaoxuzhiController {
    @RequestMapping("/front/goupiaoxuzhi")
    public String execute(){
        return "goupiaoxuzhi";
    }
}
