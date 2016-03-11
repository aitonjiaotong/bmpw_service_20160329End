package com.aiton.bmgj.service.serviceRealize;

import com.aiton.bmgj.dao.BusRepostory;
import com.aiton.bmgj.entity.Bus;
import com.aiton.bmgj.service.serviceImpl.BusServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公交车业务处理
 * Created by user on 2016/3/3.
 */
public class BusService implements BusServiceImpl{
    @Resource
    private BusRepostory busRepostory;

    @Override
    public Bus findBusByBusLineId(Integer busLineId) {
        return null;
    }

    @Override
    public Bus findBusById(Integer id) {

        return null;
    }

    @Override
    public List<Bus> findBusAll() {

        return null;
    }
}
