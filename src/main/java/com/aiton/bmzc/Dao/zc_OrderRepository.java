package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.zc_Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */
public interface zc_OrderRepository extends JpaRepository<zc_Order,Integer> {
    @Query("from zc_Order where accountId=?")
    Page<zc_Order> findOrderByAccountId(Integer accountId,Pageable pageable);
    @Query("select count(o) from zc_Order as o where accountId=?")
    Object countOrderByAccountId(Integer accountId);
    @Query("from zc_Order where flag=0")
    Page<zc_Order> findIngOrder(Pageable pageable);
    @Query("select count(o) from zc_Order as o where flag=0")
    Object CountIngOrder();
    @Query("from zc_Order where hasDriver=0")
    List<zc_Order> findOrdershouldHasDriver();
}
