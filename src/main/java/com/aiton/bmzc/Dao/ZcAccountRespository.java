package com.aiton.bmzc.dao;

import com.aiton.bmpw.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 下午2:38
 * To change this template use File | Settings | File Templates.
 */
public interface ZcAccountRespository extends JpaRepository<Account,Integer> {
}
