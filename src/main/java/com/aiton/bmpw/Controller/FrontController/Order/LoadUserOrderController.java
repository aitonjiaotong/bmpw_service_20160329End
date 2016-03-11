package com.aiton.bmpw.Controller.FrontController.Order;

import com.aiton.bmpw.Entity.Bmpw_Order;
import com.aiton.bmpw.Entity.Show.pw_Order_show;
import com.aiton.bmpw.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-24
 * Time: 上午9:04
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoadUserOrderController {
    @Resource
    private OrderService service;
    @RequestMapping("/front/ladorderbyuser")
    @ResponseBody
    public pw_Order_show execute(Integer account_id,Integer page){
         pw_Order_show orders=service.loadOrderByUserId(account_id,page);
         return orders;
    }
}
