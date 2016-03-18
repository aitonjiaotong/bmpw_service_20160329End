package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.zc_plan;
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
public interface zc_PlanRepository extends JpaRepository<zc_plan,Integer> {
    @Query("from zc_plan where flag=0")
    List<zc_plan> loadplans();
}
