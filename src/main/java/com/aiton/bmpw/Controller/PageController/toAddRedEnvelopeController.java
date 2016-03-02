package com.aiton.bmpw.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-22
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class toAddRedEnvelopeController {
    @RequestMapping("/addRedEnvelope")
    public String execute(){
        return "AddRedEnvelope";
    }
}
