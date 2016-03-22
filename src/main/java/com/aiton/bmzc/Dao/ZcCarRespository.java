package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.ZcCar;
import com.aiton.bmzc.Entity.ZcCarPlan;
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
public interface ZcCarRespository extends JpaRepository<ZcCar,Integer>{
    @Query("select distinct new com.aiton.bmzc.Entity.ZcCarPlan(c.model,c.type,c.box,c.pailiang,c.seat,c.zidong,c.planId,c.image) from ZcCar as c where status=0")
    List<ZcCarPlan> findCanUseCar(Pageable pageable);
    @Query("select distinct new com.aiton.bmzc.Entity.ZcCarPlan(c.model,c.type,c.box,c.pailiang,c.seat,c.zidong,c.planId,c.image) from ZcCar as c where status=0")
    List<ZcCarPlan> CountCanUseCar();
    @Query("from ZcCar as c where c.model=(:model) and c.type=(:ctype) and c.box=(:box) and c.pailiang=(:pailiang) and c.seat=(:seat) and c.planId=(:planId) and c.status=0")
    List<ZcCar>find(@Param("model")String model,@Param("ctype")String ctype,@Param("box")String box,@Param("pailiang")String pailiang,@Param("seat")Integer seat,@Param("planId")Integer planId);
    @Query("from ZcCar where lei=?")
    List<ZcCar> findCar(Integer lei);
    @Query("select c from ZcCar as c where licensePlate like ?")
    List<ZcCar> findCarsLicensePlateLike(String licensePlate,Pageable pageable);
    @Query("select count(c) from ZcCar as c where licensePlate like ?")
    Object countCarsLicensePlateLike(String licensePlate);
}
