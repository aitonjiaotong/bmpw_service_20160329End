package com.aiton.bmpw.controller.frontController.Order;

import com.aiton.bmpw.entity.Bmpw_Order;
import com.aiton.bmpw.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-2
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CompleteOrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/order/completeorder")
    @ResponseBody
    public Bmpw_Order execute(Integer order_id,Integer redEnvelope_id){
        Bmpw_Order order=orderService.completeOrder(order_id,redEnvelope_id);
        return order;
    }
}
