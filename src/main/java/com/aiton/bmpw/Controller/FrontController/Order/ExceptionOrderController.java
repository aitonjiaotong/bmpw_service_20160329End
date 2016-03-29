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
 * Date: 16-3-16
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ExceptionOrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/front/exceptionorder")
    @ResponseBody
    public Bmpw_Order execute(Integer order_id,Integer flag){
         Bmpw_Order order=orderService.exceptionOrder(order_id,flag);
         return order;
    }
}
