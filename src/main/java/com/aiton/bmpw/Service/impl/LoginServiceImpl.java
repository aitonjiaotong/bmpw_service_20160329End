package com.aiton.bmpw.service.impl;

import com.aiton.bmpw.dao.AccountReponstory;
import com.aiton.bmpw.entity.Account;
import com.aiton.bmpw.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */

/**
 * 登陆相关
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private AccountReponstory accountReponstory;
    @Override
    public Account findOrAdd(String phone,String login_id) {
        Account account=accountReponstory.findByPhone(phone);

        if(account==null){
            account=new Account();
            account.setPhone(phone);
            account.setName(phone);
            account.setLogin_id(login_id);
            account=accountReponstory.saveAndFlush(account);
            return account;
        }else{
            account.setLogin_id(login_id);
            account=accountReponstory.saveAndFlush(account);
            return account;
        }
         //To change body of implemented methods use File | Settings | File Templates.
    }
}
