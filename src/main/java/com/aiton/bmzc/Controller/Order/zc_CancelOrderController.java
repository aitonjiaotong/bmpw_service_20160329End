package com.aiton.bmzc.Controller.Order;

import com.aiton.bmzc.Service.zc_OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 上午9:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class zc_CancelOrderController {
    @Resource
    private zc_OrderService orderService;
    @RequestMapping("/zc/order/cancelorder")
    public Boolean execute(Integer order_id){
        Boolean flag=orderService.cancelOrder(order_id);
        return flag;
    }
}