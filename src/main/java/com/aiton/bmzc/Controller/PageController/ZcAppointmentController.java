package com.aiton.bmzc.Controller.PageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 预约页面跳转
 * Created by user on 2016/3/19.
 */
@Controller
public class ZcAppointmentController {
    @RequestMapping("/toZC_Appointment")
    public String execute(){
        return "zc_appointment";
    }
}
