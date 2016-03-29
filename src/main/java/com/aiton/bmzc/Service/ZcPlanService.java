package com.aiton.bmzc.service;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmzc.entity.ZcPlan;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-10
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public interface ZcPlanService {
    ZcPlan addPlan(ZcPlan plan);
    Boolean delPlan(Integer plan_id);
    DataTables loadPlans(Integer draw,Integer start,Integer length,HttpServletRequest request) throws UnsupportedEncodingException;
    List<ZcPlan>loadPlan();
    DataTables loadCanUsePlan(Integer draw,Integer start,Integer length);
}
