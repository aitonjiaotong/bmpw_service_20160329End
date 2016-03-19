package com.aiton.bmdc.service.inter;

import com.aiton.bmdc.entity.DCOrder;

import java.util.List;

/**
 * 订单业务接口：
 * 1.根据ID查找订单；
 * 2.根据状态和ID查找订单；
 * 3.根据状态查找所有该状态订单；
 * 4.订单状态改变时，更新订单队列(完成时存入数据库)；
 * Created by user on 2016/3/19.
 */
public interface OrderInter {
    DCOrder findOrderById(Integer order_id);
    DCOrder findOrderByIdAndStatus(Integer order_id,Integer status);
    List<DCOrder> findDCOrdersByStatus(Integer status);
    boolean updateOrderQueue(DCOrder order);
}
