package com.aiton.bmzc.Service.Impl;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Dao.zc_PlanRepository;
import com.aiton.bmzc.Entity.zc_plan;
import com.aiton.bmzc.Service.Zc_PlanService;
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
public class Zc_PlanServiceImpl implements Zc_PlanService {
    @Resource
    private zc_PlanRepository planRepository;
    @Override
    public zc_plan addPlan(zc_plan plan) {
        plan.setFlag(0);
        plan=planRepository.saveAndFlush(plan);
        return plan;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean delPlan(Integer plan_id) {
        zc_plan plan=null;
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
