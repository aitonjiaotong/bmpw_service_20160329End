package com.aiton.bmzc.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 上午10:39
 * To change this template use File | Settings | File Templates.
 */
public class ZcOrderCar {
    private ZcCar car;
    private ZcOrder order;

    public ZcCar getCar() {
        return car;
    }

    public void setCar(ZcCar car) {
        this.car = car;
    }

    public ZcOrder getOrder() {
        return order;
    }

    public void setOrder(ZcOrder order) {
        this.order = order;
    }
}
