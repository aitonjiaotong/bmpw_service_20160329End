package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.zc_Car;
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
    @Query("from zc_Car where status=0")
    List<zc_Car> findCanUseCar();
}
