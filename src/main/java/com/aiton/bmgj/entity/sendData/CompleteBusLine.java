package com.aiton.bmgj.entity.sendData;

import com.aiton.bmgj.entity.Bus;
import com.aiton.bmgj.entity.BusLine;

import java.util.HashMap;

/**
 * Created by user on 2016/3/10.
 */
public class CompleteBusLine {
    private BusLine busLine;
    private HashMap<Bus,CompleteBus> map;


    public BusLine getBusLine() {
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        this.busLine = busLine;
    }

    public HashMap<Bus, CompleteBus> getMap() {
        return map;
    }

    public void setMap(HashMap<Bus, CompleteBus> map) {
        this.map = map;
    }


}
