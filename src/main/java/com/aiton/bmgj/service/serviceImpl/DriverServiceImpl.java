package com.aiton.bmgj.service.serviceImpl;

import com.aiton.bmgj.entity.Driver;

/**
 * Created by user on 2016/3/7.
 */
public interface DriverServiceImpl {
    Driver findDriverById(Integer id);
    Driver findDriverByBusLineId(Integer busLineId);
}
