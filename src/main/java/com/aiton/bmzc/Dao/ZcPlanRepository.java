package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.ZcPlan;
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
    List<ZcPlan> loadplans(Pageable pageable);
}
