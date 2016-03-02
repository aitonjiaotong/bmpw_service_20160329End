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
 * Time: 上午9:24
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Controller
public class UpdateIconController {
    @Resource
    private AccountService accountService;
    @RequestMapping("/account/updateIcon")
    @ResponseBody
    public Account execute(Integer account_id,String image){
        Account account=accountService.updateIcon(account_id,image);
        System.out.println(account.getImage());
        System.out.println(account.getImage().length());
        return account;
    }
}
