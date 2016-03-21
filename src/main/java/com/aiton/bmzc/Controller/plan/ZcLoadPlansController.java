package com.aiton.bmzc.Controller.plan;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Service.ZcPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadPlansController {
    @Resource
    private ZcPlanService planService;
    @RequestMapping("/zc/plan/loadplan")
    @ResponseBody
    public DataTables execute(Integer draw,Integer start,Integer length){
         DataTables dataTables=planService.loadPlans(draw,start,length);
        return dataTables;
    }
}
