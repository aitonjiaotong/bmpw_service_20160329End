package com.aiton.bmzc.Service;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Entity.Zc_Contains_num;
import com.aiton.bmzc.Entity.zc_Order;
import com.aiton.bmzc.Entity.zc_order_request;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 */
public interface zc_OrderService {
    zc_Order addDriver(Integer order_id,Integer driver_id);
    zc_Order addOrder(zc_order_request order_request);
    Boolean cancelOrder(Integer order_id);
    zc_Order loadOrder(Integer order_id,Timestamp huancheDate,Double afterMileage,Double shouyajin);
    zc_Order completeOrder(Integer order_id,Double price,Double shouyajin,String note,String sale);
    Zc_Contains_num loadorderByaccount(Integer accountId,Integer page);
    DataTables loadCanCompleteOrder(Integer draw,Integer start,Integer length);
}
