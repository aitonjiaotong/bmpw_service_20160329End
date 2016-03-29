package com.aiton.bmpw.dao;

import com.aiton.bmpw.entity.Bmpw_Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
    @Query("from Bmpw_Order where bookLogAID=?")
    Bmpw_Order findOrderByBookLogAID(String bookLogAID);
    @Query("select o from Bmpw_Order as o where flag is not null order by date")
    Page<Bmpw_Order> findExceptionOrders(Pageable pageable);
    @Query("select count(o) from Bmpw_Order as o where o.phone like ? and flag is not null")
    Object CountExceptionPhoneLike(String phone);
    @Query("select o from Bmpw_Order as o where o.phone like ? and flag is not null order by o.date")
    Page<Bmpw_Order> findExceptionPhoneLike(String phone,Pageable pageable);
}
