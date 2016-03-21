package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.ZcOrder;
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
public interface ZcOrderRepository extends JpaRepository<ZcOrder,Integer> {
    @Query("from ZcOrder where accountId=?")
    Page<ZcOrder> findOrderByAccountId(Integer accountId,Pageable pageable);
    @Query("select count(o) from ZcOrder as o where accountId=?")
    Object countOrderByAccountId(Integer accountId);
    @Query("from ZcOrder where flag=0")
    Page<ZcOrder> findIngOrder(Pageable pageable);
    @Query("select count(o) from ZcOrder as o where flag=0")
    Object CountIngOrder();
    @Query("from ZcOrder where hasDriver=0")
    List<ZcOrder> findOrdershouldHasDriver();
}
