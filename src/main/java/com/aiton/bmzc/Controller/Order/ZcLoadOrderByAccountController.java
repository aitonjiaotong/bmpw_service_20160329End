package com.aiton.bmzc.controller.Order;

import com.aiton.bmzc.Entity.ZcContainsNum;
import com.aiton.bmzc.Service.ZcOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 上午9:22
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadOrderByAccountController {
    @Resource
    private ZcOrderService orderService;
    @RequestMapping("/zc/order/loadbyaccount")
    @ResponseBody
    public ZcContainsNum execute(Integer account_id,Integer page){
        ZcContainsNum orders=orderService.loadorderByaccount(account_id,page);
        return orders;
    }
}
