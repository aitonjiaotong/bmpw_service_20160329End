package com.aiton.bmdc.service.queue;

import com.aiton.bmdc.entity.DCOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2016/3/19.
 */
@Service
@Scope(value="singleton")
public class ExecutingOrderQueue extends BaseQueue{
    /**状态为正在执行（乘客已上车）的订单*/
    private static final Integer order_status = 2;

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
