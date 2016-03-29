package com.aiton.bmzc.dao;

import com.aiton.bmzc.entity.ZcPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
public interface ZcPlanRepository extends JpaRepository<ZcPlan,Integer> {
    @Query("from ZcPlan where flag=0")
    List<ZcPlan> loadplan();
    @Query("select p from ZcPlan as p where p.name like ?")
    Page<ZcPlan> loadPlansByNameLike(String name,Pageable pageable);
    @Query("select count(p) from ZcPlan p where p.name like ?")
    Object countByNameLike(String name);
    @Query("select p from ZcPlan as p where flag=0")
    Page<ZcPlan> loadCanUsePlan(Pageable pageable);
    @Query("select count(p) from ZcPlan p where flag=0")
    Object CountCanUsePlan();
}
