package com.aiton.bmgj.service.serviceImpl;

import com.aiton.bmgj.entity.LastGpsData;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by user on 2016/3/7.
 */
public interface LastGpsDataServiceImpl {
    List<LastGpsData> findLastGpsDatasByBusLine(Integer busLineId,Integer up_down);
    LastGpsData findLastGpsDataByBusId(Integer busId);
    JSONObject findLastGpsDatasByStationId(Integer stationId);
}
