package com.aiton.bmgj.controller;

import com.aiton.bmgj.entity.BusLine;
import com.aiton.bmgj.entity.Station;
import com.aiton.bmgj.entity.StationBase;
import com.aiton.bmgj.service.serviceRealize.BusLineService;
import com.aiton.bmgj.service.serviceRealize.StationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 站点信息控制组件
 * Created by user on 2016/3/7.
 */
@Controller
public class GJStationController {
    @Resource
    private StationService stationService;
    @Resource
    private BusLineService busLineService;

    @RequestMapping("/getStationsByBusLineNo")
    @ResponseBody
    public List<Station> execute(Integer busLine_no){
        BusLine busLine = busLineService.findBusLineByNo(busLine_no);
        if(busLine == null){
            System.out.println("空的对象！！！");
            return null;
        }
        List<Station> list = stationService.
                findStationByBusLineId(busLine.getBusline_id());
        return list;
    }

    @RequestMapping("/getStationById")
    @ResponseBody
    public Station getBase(Integer stationId){
        //System.out.println("In getStation()");
        Station station = stationService.findStationById(stationId);
        if(station == null){
            System.out.println("空的对象。。。。");
        }
        return station;
    }
    @ResponseBody
    @RequestMapping("/getStationBase")
    public List<StationBase> getStationBase(){
        List<StationBase> list = stationService.findStationBaseAll();
        return list;
    }
}
