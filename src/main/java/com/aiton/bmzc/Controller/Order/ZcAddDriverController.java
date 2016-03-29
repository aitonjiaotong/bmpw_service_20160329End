package com.aiton.bmzc.controller.Order;

import com.aiton.bmzc.entity.ZcOrder;
import com.aiton.bmzc.service.ZcOrderService;
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
public class ZcAddDriverController {
    @Resource
    private ZcOrderService orderService;
    @RequestMapping("/zc/order/adddriver")
    public ZcOrder execute(Integer order_id,Integer driver_id){
        ZcOrder order=orderService.addDriver(order_id,driver_id);
        return order;
    }
}
