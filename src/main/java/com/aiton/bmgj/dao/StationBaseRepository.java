package com.aiton.bmgj.dao;

import com.aiton.bmgj.entity.StationBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by user on 2016/3/4.
 */
public interface StationBaseRepository extends JpaRepository<StationBase,Integer>{
    @Query("from StationBase where station_id=? and station_name=?")
    StationBase findStationBaseByStationIdAndStationName(Integer station_id,String station_name);
    @Query("from StationBase where chineseFirstLetter like ?")
    List<StationBase> findStationBaseByLetter(String letter);
    @Query("from StationBase where station_name like ?")
    List<StationBase> findStationBaseByName(String name);
}
