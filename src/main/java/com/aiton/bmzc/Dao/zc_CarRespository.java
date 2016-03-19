package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.zc_Car;
import com.aiton.bmzc.Entity.zc_car_plan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午3:24
 * To change this template use File | Settings | File Templates.
 */
public interface zc_CarRespository extends JpaRepository<zc_Car,String>{
    @Query("select distinct new com.aiton.bmzc.Entity.zc_car_plan(c.model,c.type,c.box,c.pailiang,c.seat,c.zidong,c.planId,c.image) from zc_Car as c where status=0")
    List<zc_car_plan> findCanUseCar(Pageable pageable);
    @Query("from zc_Car as c where c.model=(:model) and c.type=(:ctype) and c.box=(:box) and c.pailiang=(:pailiang) and c.seat=(:seat) and c.planId=(:planId) and c.status=0")
    List<zc_Car>find(@Param("model")String model,@Param("ctype")String ctype,@Param("box")String box,@Param("pailiang")String pailiang,@Param("seat")Integer seat,@Param("planId")Integer planId);
}
