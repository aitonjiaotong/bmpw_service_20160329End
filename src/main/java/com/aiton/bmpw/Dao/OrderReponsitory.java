package com.aiton.bmpw.Dao;

import com.aiton.bmpw.Entity.Bmpw_Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 上午10:30
 * To change this template use File | Settings | File Templates.
 */
public interface OrderReponsitory extends JpaRepository<Bmpw_Order,Integer>{
    @Query("select o from Bmpw_Order as o where account_id=?")
    Page<Bmpw_Order> findByUserId(Integer account_id,Pageable pageable);
    @Query("select count(o) from Bmpw_Order as o where o.account_id=?")
    Object CountByAccount(Integer account_id);
    @Query("select count(o) from Bmpw_Order as o where o.phone like ?")
    Object CountPhoneLike(String phone);
    @Query("select o from Bmpw_Order as o where o.phone like ?")
    Page<Bmpw_Order> findPhoneLike(String phone,Pageable pageable);
}
