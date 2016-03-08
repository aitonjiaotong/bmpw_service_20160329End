package com.aiton.bmgj.service.serviceImpl;

import com.aiton.bmgj.entity.Station;
import com.aiton.bmgj.entity.StationBase;

import java.util.List;

/**
 * Created by user on 2016/3/7.
 */
public interface StationServiceImpl {
    Station findStationById(Integer id);
    List<Station> findStationByBusLineId(Integer busLineId);
    StationBase findStationBaseByStationId(Integer id);
    List<StationBase> findStationBaseByBusLineId(Integer busLineId);
    List<StationBase> findStationBaseAll();
}
