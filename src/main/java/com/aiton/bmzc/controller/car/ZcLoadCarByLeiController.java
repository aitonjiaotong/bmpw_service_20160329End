package com.aiton.bmzc.controller.car;

import com.aiton.bmzc.Entity.ZcCarAndPlan;
import com.aiton.bmzc.Service.ZcOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-22
 * Time: 下午12:24
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadCarByLeiController {
    @Resource
    private ZcOrderService orderService;
    @RequestMapping("/zc/order/loadcarbylei")
    @ResponseBody
    public ZcCarAndPlan execute(Integer lei){
        ZcCarAndPlan carAndPlan=orderService.beforeOrder(lei);
        return carAndPlan;
    }
}
