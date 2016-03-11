package com.aiton.bmgj.dao;

import com.aiton.bmgj.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by user on 2016/3/3.
 */
public interface DriverRepository extends JpaRepository<Driver,Integer> {
    @Query("from Driver where driver_id=?")
    Driver findDriverByDriverId(Integer driver_id);
}
