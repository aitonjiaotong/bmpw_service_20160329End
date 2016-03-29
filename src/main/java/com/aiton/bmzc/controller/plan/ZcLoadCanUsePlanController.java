package com.aiton.bmzc.controller.plan;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmzc.service.ZcPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-23
 * Time: 上午11:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadCanUsePlanController {
    @Resource
    private ZcPlanService zcPlanService;
    @RequestMapping("/zc/plan/loadCanUsePlan")
    @ResponseBody
    public DataTables execute(Integer draw,Integer start,Integer length){
        DataTables dataTables=zcPlanService.loadCanUsePlan(draw,start,length);
        return dataTables;
    }
}
