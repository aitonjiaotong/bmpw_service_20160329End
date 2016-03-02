package com.aiton.bmpw.Controller.FrontController.Order;

import com.aiton.bmpw.Entity.Bmpw_Order;
import com.aiton.bmpw.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-24
 * Time: 上午9:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class AddOrderController {
    @Resource
    private OrderService service;
    @RequestMapping("/front/addorder")
    @ResponseBody
    public Bmpw_Order execute(String bookLogAID, Integer account_id,Integer redEnvelope_id){
        Bmpw_Order order=service.addOrder(bookLogAID,account_id,redEnvelope_id);
        return order;
    }
}
