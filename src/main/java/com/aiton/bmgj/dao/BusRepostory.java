package com.aiton.bmgj.dao;

import com.aiton.bmgj.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by user on 2016/3/3.
 */
public interface BusRepostory extends JpaRepository<Bus,Integer> {
    @Query("from Bus where car_id=?")
    Bus findBusByCarId(Integer car_id);
}
