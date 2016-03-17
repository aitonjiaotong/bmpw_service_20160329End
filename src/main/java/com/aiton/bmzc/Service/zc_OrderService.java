package com.aiton.bmzc.Service;

import com.aiton.bmzc.Entity.zc_Order;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 */
public interface zc_OrderService {
    zc_Order addDriver(Integer order_id,Integer driver_id);
    zc_Order addOrder(zc_Order order);
    Boolean cancelOrder(Integer order_id);
    zc_Order loadOrder(Integer order_id,Timestamp huancheDate,Double afterMileage,Double shouyajin);
    zc_Order completeOrder(Integer order_id,Double price,Double shouyajin);
    List<zc_Order> loadorderByaccount(Integer accountId);
    List<zc_Order>loadCanCompleteOrder();
}
