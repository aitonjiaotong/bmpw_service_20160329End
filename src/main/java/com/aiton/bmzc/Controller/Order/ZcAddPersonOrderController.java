package com.aiton.bmzc.controller.Order;

import com.aiton.bmzc.entity.ZcOrder;
import com.aiton.bmzc.entity.ZcOrderRequest;
import com.aiton.bmzc.service.ZcOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcAddPersonOrderController {
    @Resource
    private ZcOrderService orderService;
    @RequestMapping("/zc/order/person/addorder")
    @ResponseBody
    public ZcOrder execute(ZcOrderRequest request){
        ZcOrder order=orderService.addOrder2(request);
        return order;
    }

}
