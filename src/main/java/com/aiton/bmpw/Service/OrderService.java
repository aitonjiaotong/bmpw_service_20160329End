package com.aiton.bmpw.service;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.entity.Bmpw_Order;
import com.aiton.bmpw.entity.show.pw_Order_show;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-22
 * Time: 上午9:05
 * To change this template use File | Settings | File Templates.
 */
public interface OrderService {
    Bmpw_Order addOrder(String BookLogAID,Integer account_id);
    pw_Order_show loadOrderByUserId(Integer account_id,Integer page);
    DataTables loadOrders(Integer draw,Integer start,Integer length,HttpServletRequest request) throws ServiceException, RemoteException;
    Bmpw_Order completeOrder(Integer order_id,Integer redEnvelope_id);
    Bmpw_Order exceptionOrder(Integer order_id,Integer flag);
    Boolean checkOrder(Integer order_id);//确认订单
    DataTables loadExceptionOrders(Integer draw,Integer start,Integer length,HttpServletRequest request);//列出有异常的订单
}
