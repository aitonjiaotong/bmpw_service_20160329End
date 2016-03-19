package com.aiton.bmdc.service.queue;

import com.aiton.bmdc.entity.DCOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 已接受等待执行（未执行）的订单队列
 * Created by user on 2016/3/18.
 */
@Service
@Scope(value="singleton")
public class NullExecuteOrderQueue extends BaseQueue{
    /**状态为司机已接受，等待执行*/
    private static final Integer order_status = 1;

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
