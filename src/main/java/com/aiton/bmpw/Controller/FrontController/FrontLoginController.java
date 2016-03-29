package com.aiton.bmpw.controller.frontController;

import com.aiton.bmpw.entity.Account;
import com.aiton.bmpw.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午10:31
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class FrontLoginController {
    @Resource
    private LoginService service;
    @RequestMapping("/front/FrontLogin")
    @ResponseBody
    public Account execute(String phone,String login_id){
        Account account=service.findOrAdd(phone,login_id);
        return account;
    }
}
