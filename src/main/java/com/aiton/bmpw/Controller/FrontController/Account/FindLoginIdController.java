package com.aiton.bmpw.Controller.FrontController.Account;

import com.aiton.bmpw.Entity.Account;
import com.aiton.bmpw.Service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-1
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class FindLoginIdController {
    @Resource
    private AccountService accountService;
    @RequestMapping("/account/findLogin_id")
    @ResponseBody
    public String execute(Integer account_id){
        Account account=accountService.findOne(account_id);
        String login_id=account.getLogin_id();
        return login_id;
    }
}
