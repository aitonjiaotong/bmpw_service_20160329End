package com.aiton.bmgj.service.serviceImpl;

import com.aiton.bmgj.entity.PlanRunTime;

import java.util.List;

/**
 * Created by user on 2016/3/7.
 */
public interface PlanRunTimeServiceImpl {
    PlanRunTime findPlanRunTimeById(Integer id);
    List<PlanRunTime> findPlanRunTimeByBusLine(Integer busLineId);
    List<PlanRunTime> findPlanRunTimeAll_now();
}
