package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class toExceptionOrdersController {
    @RequestMapping("/exceptionorders")
    public String execute(){
        return "exceptionOrders";
    }
}
