package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-26
 * Time: 下午12:37
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ToZonesController {
    @RequestMapping("/zones")
    public String execute(){
        return "Zones";
    }
}
