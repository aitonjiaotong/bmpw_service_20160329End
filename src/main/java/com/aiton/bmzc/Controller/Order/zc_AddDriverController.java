package com.aiton.bmzc.Controller.Order;

import com.aiton.bmzc.Entity.zc_Order;
import com.aiton.bmzc.Service.zc_OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 上午9:28
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class zc_AddDriverController {
    @Resource
    private zc_OrderService orderService;
    @RequestMapping("/zc/order/adddriver")
    public zc_Order execute(Integer order_id,Integer driver_id){
        zc_Order order=orderService.addDriver(order_id,driver_id);
        return order;
    }
}
