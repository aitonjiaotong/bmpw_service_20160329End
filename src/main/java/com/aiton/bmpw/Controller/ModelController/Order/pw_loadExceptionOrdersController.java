package com.aiton.bmpw.Controller.ModelController.Order;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class pw_loadExceptionOrdersController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/order/loadexceptionorders")
    @ResponseBody
    public DataTables execute(Integer draw,Integer start,Integer length,HttpServletRequest request){
        DataTables dataTables=orderService.loadExceptionOrders(draw,start,length,request);
        return dataTables;
    }
}
