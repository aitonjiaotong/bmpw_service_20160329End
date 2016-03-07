package com.aiton.bmgj.service.serviceImpl;

import com.aiton.bmgj.entity.Bus;

import java.util.List;

/**
 * 公交车业务接口
 * Created by user on 2016/3/3.
 */
public interface BusServiceImpl {
    Bus findBusById(Integer id);
    List<Bus> findBusAll();
}
