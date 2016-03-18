package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.zc_Car;
import com.aiton.bmzc.Entity.zc_car_plan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午3:24
 * To change this template use File | Settings | File Templates.
 */
public interface zc_CarRespository extends JpaRepository<zc_Car,String>{
    @Query("select distinct new com.aiton.bmzc.Entity.zc_car_plan(c.model,c.type,c.box,c.pailiang,c.seat,c.zidong,c.color,c.planId,c.image) from zc_Car as c where status=0")
    List<zc_car_plan> findCanUseCar(Pageable pageable);
}
