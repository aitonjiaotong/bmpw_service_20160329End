package com.aiton.bmpw.Dao;

import com.aiton.bmpw.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */
public interface AccountReponstory extends JpaRepository<Account,Integer>{
    @Query("from Account where phone=?")
    Account findByPhone(String phone);
    @Query("from Account where name=?")
    Account findByName(String name);
    @Query("select distinct a.id from Account as a where a.name like ?")
    List<Object> findByNameLike(String name);
}
