package com.aiton.bmpw.controller.modelController.Order;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 下午1:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoadOrdersController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/order/loadorders")
    @ResponseBody
    public DataTables execute(Integer draw,Integer start,Integer length,HttpServletRequest request) throws ServiceException, RemoteException {
        DataTables dataTables=orderService.loadOrders(draw,start,length,request);
        return dataTables;
    }
}
