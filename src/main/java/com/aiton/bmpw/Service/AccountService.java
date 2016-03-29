package com.aiton.bmpw.service;

import com.aiton.bmpw.entity.Account;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-5
 * Time: 下午5:46
 * To change this template use File | Settings | File Templates.
 */
public interface AccountService {
    Account updateIcon(Integer account_id,String image);
    Account findOne(Integer account_id);
    Account updateName(Integer account_id,String name);
}
