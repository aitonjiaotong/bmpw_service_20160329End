package com.aiton.bmzc.Service.Impl;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Dao.ZcPlanRepository;
import com.aiton.bmzc.Entity.ZcPlan;
import com.aiton.bmzc.Service.ZcPlanService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
    private ZcPlanRepository planRepository;
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
    public DataTables loadPlans(Integer draw, Integer start, Integer length,HttpServletRequest request) throws UnsupportedEncodingException {
        String search=request.getParameter("search[value]");
        Integer page=start/length;
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        dataTables.setRecordsTotal(planRepository.count());
        if(search==null||"".equals(search)){
            dataTables.setData(planRepository.findAll(new PageRequest(page, length, new Sort(Sort.Direction.ASC,"flag"))).getContent());
            dataTables.setRecordsFiltered(planRepository.count());
        }else{
            String str=new String(search.getBytes("ISO-8859-1"),"utf-8");
            //System.out.println(str);
            str="%"+str+"%";
            Object o=planRepository.countByNameLike(str);
            dataTables.setData(planRepository.loadPlansByNameLike(str,new PageRequest(page,length,new Sort(Sort.Direction.ASC,"flag"))).getContent());
            if(o==null){
                dataTables.setRecordsFiltered(0l);
            }else{
                dataTables.setRecordsFiltered(Long.valueOf(o.toString()));
            }

        }
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<ZcPlan> loadPlan() {
        List<ZcPlan>plans=planRepository.loadplan();
        return plans;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DataTables loadCanUsePlan(Integer draw, Integer start, Integer length) {
        DataTables dataTables=new DataTables();
        Integer page=start/length;
        dataTables.setDraw(draw);
        Object o=planRepository.CountCanUsePlan();
        if(o==null){
            dataTables.setRecordsFiltered(0l);
            dataTables.setRecordsTotal(0l);
        }else{
            dataTables.setRecordsTotal(Long.valueOf(planRepository.CountCanUsePlan().toString()));
            dataTables.setRecordsFiltered(Long.valueOf(planRepository.CountCanUsePlan().toString()));
        }
        dataTables.setData(planRepository.loadCanUsePlan(new PageRequest(page,length)).getContent());
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
