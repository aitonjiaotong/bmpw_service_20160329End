package com.aiton.bmzc.entity;

import com.aiton.bmpw.entity.Account;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-24
 * Time: 上午8:41
 * To change this template use File | Settings | File Templates.
 */
public class ZcCarPlanOrderAccount {
    private ZcCar car;
    private ZcPlan plan;
    private ZcOrder order;
    private Account account;
    public ZcCar getCar() {
        return car;
    }

    public void setCar(ZcCar car) {
        this.car = car;
    }

    public ZcPlan getPlan() {
        return plan;
    }

    public void setPlan(ZcPlan plan) {
        this.plan = plan;
    }

    public ZcOrder getOrder() {
        return order;
    }

    public void setOrder(ZcOrder order) {
        this.order = order;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public ZcCarPlanOrderAccount(){}
    public ZcCarPlanOrderAccount(ZcCar car, ZcPlan plan, ZcOrder order, Account account) {
        this.car = car;
        this.plan = plan;
        this.order = order;
        this.account = account;
    }
}
