package com.aiton.bmzc.controller.plan;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmzc.service.ZcPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

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
    public DataTables execute(Integer draw,Integer start,Integer length,HttpServletRequest request) throws UnsupportedEncodingException {
         DataTables dataTables=planService.loadPlans(draw,start,length,request);
        return dataTables;
    }
}
