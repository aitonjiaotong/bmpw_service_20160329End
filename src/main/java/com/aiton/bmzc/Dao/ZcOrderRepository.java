package com.aiton.bmzc.dao;

import com.aiton.bmzc.entity.ZcOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query("select o from ZcOrder as o where flag=0")
    Page<ZcOrder> findIngOrder(Pageable pageable);
    @Query("select o from ZcOrder as o where flag=3")
    Page<ZcOrder> findUnsettleOrder(Pageable pageable);
    @Query("select count(o) from ZcOrder as o where flag=3")
    Object countUnsettleOrder();
    @Query("select count(o) from ZcOrder as o where flag=0")
    Object CountIngOrder();
    @Query("from ZcOrder where hasDriver=0")
    List<ZcOrder> findOrdershouldHasDriver();
    @Query("from ZcOrder where flag=0 and driverId=?")
    ZcOrder checkDriver(Integer driverId);
    @Query("select o from ZcOrder as o where flag=0 and accountId in (:accounts)")
    Page<ZcOrder> findIngOrderByAccount(@Param("accounts")List<Object> accounts,Pageable pageable);
    @Query("select count(o) from ZcOrder as o where flag=0 and accountId in (:accounts)")
    Object countIngOrderByAccount(@Param("accounts")List<Object> accounts);
    @Query("select o from ZcOrder as o where flag=3 and accountId in (:accounts)")
    Page<ZcOrder> findUnsettleOrderByAccount(@Param("accounts")List<Object> accounts,Pageable pageable);
    @Query("select count(o) from ZcOrder as o where flag=3 and accountId in (:accounts)")
    Object countUnsettleOrderByAccount(@Param("accounts")List<Object> accounts);
}
