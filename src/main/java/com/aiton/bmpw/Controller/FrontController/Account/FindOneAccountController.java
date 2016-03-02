package com.aiton.bmpw.Controller.FrontController.Account;

import com.aiton.bmpw.Entity.Account;
import com.aiton.bmpw.Service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class FindOneAccountController {
    @Resource
    private AccountService accountService;
    @RequestMapping("/account/findOne")
    @ResponseBody
    public Account execute(Integer account_id){
        Account account=accountService.findOne(account_id);
        return account;
    }
}
