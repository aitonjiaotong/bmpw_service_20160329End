package com.aiton.bmgj.service.serviceImpl;

import com.aiton.bmgj.entity.Bus;
import com.aiton.bmgj.entity.BusLine;

import java.util.List;

/**
 * Created by user on 2016/3/7.
 */
public interface BusLineServiceImpl {
    BusLine findBusLineById(Integer id);
    List<BusLine> findBusLineAll();
    BusLine findBusLineByNo(Integer no);
}
