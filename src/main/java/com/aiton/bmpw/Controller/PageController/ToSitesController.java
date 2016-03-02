package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-26
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ToSitesController {
    @RequestMapping("/sites")
    public String execute(){
        return "Sites";
    }
}
