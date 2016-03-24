package com.aiton.bmzc.controller.Order;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Service.ZcOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-24
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadCanCompleteOrderController {
    @Resource
    private ZcOrderService zcOrderService;
    @RequestMapping("/zc/order/loadcancompleteorder")
    @ResponseBody
    public DataTables execute(Integer draw,Integer start,Integer length,HttpServletRequest request){
        DataTables dataTables=zcOrderService.loadCanCompleteOrder(draw,start,length,request);
        return dataTables;
    }
}
