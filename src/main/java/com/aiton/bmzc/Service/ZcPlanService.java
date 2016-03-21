package com.aiton.bmzc.Service;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Entity.ZcPlan;

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
    DataTables loadPlans(Integer draw,Integer start,Integer length);
}
