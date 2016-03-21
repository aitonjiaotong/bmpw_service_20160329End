package com.aiton.bmzc.Controller.plan;

import com.aiton.bmzc.Entity.ZcPlan;
import com.aiton.bmzc.Service.ZcPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 上午9:45
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcFrontLoadPlanController {
    @Resource
    private ZcPlanService planService;
    @RequestMapping("/zc/plan/frontloadplans")
    @ResponseBody
    public List<ZcPlan> execute(){
        List<ZcPlan> plans=planService.loadPlan();
        return plans;
    }
}
