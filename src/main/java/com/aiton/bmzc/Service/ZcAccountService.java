package com.aiton.bmzc.service;

import com.aiton.bmpw.entity.Account;
import com.aiton.bmpw.entity.DataTables;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
public interface ZcAccountService {
    DataTables loadAccounts(Integer draw,Integer start,Integer length,HttpServletRequest request);
    boolean addAccount(Account account);
    boolean updateAccount(Account account);
}
