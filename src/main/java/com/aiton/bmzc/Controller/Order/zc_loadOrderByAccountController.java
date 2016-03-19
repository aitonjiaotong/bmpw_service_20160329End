package com.aiton.bmzc.Controller.Order;

import com.aiton.bmzc.Entity.Zc_contains_num;
import com.aiton.bmzc.Service.zc_OrderService;
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
public class zc_loadOrderByAccountController {
    @Resource
    private zc_OrderService orderService;
    @RequestMapping("/zc/order/loadbyaccount")
    @ResponseBody
    public Zc_contains_num execute(Integer account_id,Integer page){
        Zc_contains_num orders=orderService.loadorderByaccount(account_id,page);
        return orders;
    }
}
