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
 * Date: 16-2-26
 * Time: 上午10:39
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class UpdateAccountNameController {
    @Resource
    private AccountService accountService;
    @RequestMapping("/account/updateaccountname")
    @ResponseBody
    public Account execute(Integer account_id,String name){
        Account account=accountService.updateName(account_id,name);
        return account;
    }
}
