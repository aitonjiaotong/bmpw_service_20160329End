package com.aiton.bmzc.Service.Impl;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Dao.zc_PlanRepository;
import com.aiton.bmzc.Entity.ZcPlan;
import com.aiton.bmzc.Service.ZcPlanService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-10
 * Time: 下午3:08
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ZcPlanServiceImpl implements ZcPlanService {
    @Resource
    private zc_PlanRepository planRepository;
    @Override
    public ZcPlan addPlan(ZcPlan plan) {
        plan.setFlag(0);
        plan=planRepository.saveAndFlush(plan);
        return plan;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean delPlan(Integer plan_id) {
        ZcPlan plan=null;
        try{
            plan=planRepository.findOne(plan_id);
        }catch (Exception e){
            return false;
        }
        if(plan==null){
            return false;
        }
        plan.setFlag(1);
        planRepository.saveAndFlush(plan);
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DataTables loadPlans(Integer draw, Integer start, Integer length) {
        Integer page=start/length;
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        dataTables.setRecordsTotal(planRepository.count());
        dataTables.setData(planRepository.loadplans(new PageRequest(page,length)));
        dataTables.setRecordsFiltered(planRepository.count());
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
