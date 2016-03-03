package com.aiton.bmpw.Service;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Entity.Bmpw_Order;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-22
 * Time: 上午9:05
 * To change this template use File | Settings | File Templates.
 */
public interface OrderService {
    Bmpw_Order addOrder(String BookLogAID,Integer account_id);
    List<Bmpw_Order> loadOrderByUserId(Integer user_id);
    DataTables loadOrders(Integer draw,Integer start,Integer length,HttpServletRequest request) throws ServiceException, RemoteException;
    Bmpw_Order completeOrder(Integer order_id,Integer redEnvelope_id);
}
