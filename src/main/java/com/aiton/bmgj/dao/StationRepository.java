package com.aiton.bmgj.dao;

import com.aiton.bmgj.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by user on 2016/3/3.
 */
public interface StationRepository extends JpaRepository<Station,Integer> {
    @Query("from Station where busline_id = ? and up_down = ?")
    List<Station> findStationByBusLineId(Integer busLineId,Integer up_down);
    @Query("from Station where busline_id=? and station_id=? and up_down=?")
    List<Station> findStationByBusLineIdAndStationId(Integer busline_id,Integer station_id,Integer up_down);
    @Query("select busline_id from Station where station_id =?")
    List<Integer> findBusLineIdByStationId(Integer station_id);
}
