package com.aiton.bmpw.Service.impl;

import com.aiton.bmpw.Dao.AccountReponstory;
import com.aiton.bmpw.Entity.Account;
import com.aiton.bmpw.Service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 上午9:19
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountReponstory accountReponstory;
    @Override
    public Account updateIcon(Integer account_id,String image) {
        Account account=accountReponstory.findOne(account_id);
        account.setImage(image);
        account=accountReponstory.saveAndFlush(account);
        return account;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Account findOne(Integer account_id) {
        Account account=accountReponstory.findOne(account_id);
        return account;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Account updateName(Integer account_id, String name) {
        Account account=accountReponstory.findOne(account_id);
        account.setName(name);
        account=accountReponstory.saveAndFlush(account);
        return account;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
