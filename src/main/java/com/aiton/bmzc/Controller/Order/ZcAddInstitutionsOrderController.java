package com.aiton.bmzc.controller.Order;

import com.aiton.bmzc.Entity.ZcOrder;
import com.aiton.bmzc.Entity.ZcOrderRequest;
import com.aiton.bmzc.Service.ZcOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
public class ZcAddInstitutionsOrderController {
    private ZcOrderService orderService;
    @RequestMapping("/zc/order/institutions/addorder")
    @ResponseBody
    public ZcOrder execute(ZcOrderRequest order_request){
        ZcOrder order=orderService.addOrder1(order_request);
        return order;
    }
}
