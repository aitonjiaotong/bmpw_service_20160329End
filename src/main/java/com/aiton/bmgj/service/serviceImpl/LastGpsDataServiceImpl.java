package com.aiton.bmgj.service.serviceImpl;

import com.aiton.bmgj.entity.LastGpsData;

import java.util.List;

/**
 * Created by user on 2016/3/7.
 */
public interface LastGpsDataServiceImpl {
    LastGpsData findLastGpsDataById(Integer id);
    List<LastGpsData> findLastGpsDataByBusLine(Integer busLineId);
    LastGpsData findLastGpsDataByBusId(Integer busId);
    List<LastGpsData> findLastGpsDataAll_now();
    List<LastGpsData> findLastGpsDataByStationId(Integer stationId);
}
