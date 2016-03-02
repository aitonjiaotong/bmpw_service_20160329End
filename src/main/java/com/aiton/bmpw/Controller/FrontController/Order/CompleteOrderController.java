package com.aiton.bmpw.Controller.FrontController.Order;

import com.aiton.bmpw.Entity.Bmpw_Order;
import com.aiton.bmpw.Service.OrderService;
import org.springframework.stereotype.Controller;

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
    public Bmpw_Order execute(Integer order_id,Integer redEnvelope_id){
        Bmpw_Order order=orderService.completeOrder(order_id,redEnvelope_id);
        return order;
    }
}
