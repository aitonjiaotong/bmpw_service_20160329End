package com.aiton.bmzc.controller.plan;

import com.aiton.bmzc.Service.ZcPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-22
 * Time: 下午2:16
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcDelPlanController {
    @Resource
    private ZcPlanService zcPlanService;
    @RequestMapping("/zc/plan/delplan")
    @ResponseBody
    public Boolean execute(Integer planId){
        Boolean flag=zcPlanService.delPlan(planId);
        return flag;
    }
}
