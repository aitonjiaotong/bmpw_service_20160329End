package com.aiton.bmpw.controller.frontController.Account;

import com.aiton.bmpw.entity.Account;
import com.aiton.bmpw.service.AccountService;
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
