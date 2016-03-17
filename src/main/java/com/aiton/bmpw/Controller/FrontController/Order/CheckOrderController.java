package com.aiton.bmpw.Controller.FrontController.Order;

import com.aiton.bmpw.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-16
 * Time: 上午11:34
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CheckOrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/order/checkorder")
    @ResponseBody
    public Boolean execute(Integer order_id){
        Boolean flag=orderService.checkOrder(order_id);
        return flag;
    }
}
