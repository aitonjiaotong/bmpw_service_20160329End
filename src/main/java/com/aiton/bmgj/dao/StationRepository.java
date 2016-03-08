package com.aiton.bmgj.dao;

import com.aiton.bmgj.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by user on 2016/3/3.
 */
public interface StationRepository extends JpaRepository<Station,Integer> {
    @Query("from Station where busLineId = ?")
    List<Station> findStationByBusLineId(Integer busLineId);
}
