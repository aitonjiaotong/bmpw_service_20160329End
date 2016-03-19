package com.aiton.bmdc.service.queue;

import com.aiton.bmdc.entity.DCOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 等待订单队列，单例对象，
 * 该队列内的订单全部是等待接单状态！
 * Created by user on 2016/3/18.
 */
@Service
@Scope(value="singleton")
public class WaitOrderQueue extends BaseQueue{
    /**状态为等待司机接受*/
   private static final Integer order_status = 0;

    /**
     * 入队操作
     * */
    public boolean insertInToQueue(DCOrder order){
       return super.insertOrder(order,order_status);
    }
    /**
     * 查找操作
     * */
    public DCOrder getById(Integer order_id){
        return super.getOrderById(order_id);
    }

    /**
     * 出队操作
     */
    public boolean deleteFromQueue(DCOrder order){
        return super.deleteOrder(order);
    }
}
