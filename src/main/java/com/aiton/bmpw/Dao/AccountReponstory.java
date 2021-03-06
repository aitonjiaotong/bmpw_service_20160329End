package com.aiton.bmpw.dao;

import com.aiton.bmpw.entity.Account;
import org.springframework.data.domain.Pageable;
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
    @Query("from Account where phone like ?")
    List<Account> findByPhoneLike(String phone,Pageable pageable);
    @Query("select count(a) from Account as a where a.phone like ?")
    Object CountByPhoneLike(String phone);
    @Query("select a.id from Account as a where a.phone like ?")
    List<Object> findByPhoneLike(String phone);
}
