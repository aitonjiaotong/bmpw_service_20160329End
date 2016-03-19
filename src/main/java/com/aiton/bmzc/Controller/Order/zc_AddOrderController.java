package com.aiton.bmzc.Controller.Order;

import com.aiton.bmzc.Entity.zc_Order;
import com.aiton.bmzc.Entity.zc_order_request;
import com.aiton.bmzc.Service.zc_OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 上午9:05
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class zc_AddOrderController {
    private zc_OrderService orderService;
    @RequestMapping("/zc/order/addorder")
    @ResponseBody
    public zc_Order execute(zc_order_request order_request){
        zc_Order order=orderService.addOrder(order_request);
        return order;
    }
}
