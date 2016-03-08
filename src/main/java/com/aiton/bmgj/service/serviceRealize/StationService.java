package com.aiton.bmgj.service.serviceRealize;

import com.aiton.bmgj.dao.StationBaseRepository;
import com.aiton.bmgj.dao.StationRepository;
import com.aiton.bmgj.entity.Station;
import com.aiton.bmgj.entity.StationBase;
import com.aiton.bmgj.service.serviceImpl.StationServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/3/7.
 */
@Service
public class StationService implements StationServiceImpl{
    @Resource
    private StationRepository stationRepository;
    @Resource
    private StationBaseRepository stationBaseRepository;

    @Override
    public Station findStationById(Integer id) {
        Station station = stationRepository.findOne(id);
        return station;
    }

    @Override
    public List<StationBase> findStationBaseByBusLineId(Integer busLineId) {
        List<Station> list = findStationByBusLineId(busLineId);
        List<StationBase> stationBaseList = new ArrayList<StationBase>();
        for(Station s : list){
            stationBaseList.add(stationBaseRepository.findOne(s.getStation_id()));
        }
        return stationBaseList;
    }

    @Override
    public List<StationBase> findStationBaseAll() {
        List<StationBase> list = stationBaseRepository.findAll();
        return list;
    }

    @Override
    public List<Station> findStationByBusLineId(Integer busLineId) {
        List<Station> list = stationRepository.findStationByBusLineId(busLineId);
        return list;
    }

    @Override
    public StationBase findStationBaseByStationId(Integer id) {
        StationBase stationBase = stationBaseRepository.findOne(id);
        return stationBase;
    }
}
