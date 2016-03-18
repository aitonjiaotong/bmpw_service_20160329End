package com.aiton.bmdc.service;

import com.aiton.bmdc.entity.DCOrder;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by user on 2016/3/18.
 */
public class BaseQueue {
    private LinkedBlockingQueue<DCOrder> queue;

    public LinkedBlockingQueue<DCOrder> getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue<DCOrder> queue) {
        this.queue = queue;
    }


    /**
     * 插入一条该状态的订单
     * */
    protected boolean insertOrder(DCOrder order,Integer status){
        if(order == null) return false;
        //判断是否是在等待接单状态
        if(order.getStatus() != status){
            System.out.println("插入的不是该状态的订单！");
            return false;
        }
        try {
            if(queue == null)
                queue = new LinkedBlockingQueue<DCOrder>();
            queue.put(order);
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 获取所有等待该状态的订单,不建议调用
     * */
    protected LinkedBlockingQueue<DCOrder> getOrderAll(){
        return queue;
    }

    /**
     * 按订单ID获取某个等待接单状态的订单
     * */
    protected DCOrder getOrderById(Integer order_id){
        //安全判断
        if(order_id == null){
            return null;
        }
        for(DCOrder order : queue) {
            if(order.getOrder_id()==order_id){
                return order;
            }
        }
        return null;
    }

    /**
     * 订单出列
     */
    protected boolean deleteOrder(DCOrder order){
        //安全判断
        if(order==null) return false;
        if(queue.contains(order)){
            queue.offer(order);
            return true;
        }
        return false;
    }
}
