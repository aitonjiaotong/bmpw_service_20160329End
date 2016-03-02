package com.aiton.bmpw.Service;

import com.aiton.bmpw.Entity.Account;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午10:16
 * To change this template use File | Settings | File Templates.
 */

public interface LoginService {
     Account findOrAdd(String phone,String login_id);
}
