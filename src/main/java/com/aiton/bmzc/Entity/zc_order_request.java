package com.aiton.bmzc.Entity;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 上午8:40
 * To change this template use File | Settings | File Templates.
 */
public class zc_order_request {
    private zc_car_plan car_plan;//车辆品牌&计划的集合
    private Timestamp zuchuDate; //租出时间
    private Timestamp planReturnDate;//计划还车时间
    private Double price;//总价
    private Integer status;//0：企业租车 1；个人租车
    private Double insurance;//保险金额
    private Integer getCar;//取车地点
    private Integer returnCar;//还车地点

    public zc_car_plan getCar_plan() {
        return car_plan;
    }

    public void setCar_plan(zc_car_plan car_plan) {
        this.car_plan = car_plan;
    }

    public Timestamp getZuchuDate() {
        return zuchuDate;
    }

    public void setZuchuDate(Timestamp zuchuDate) {
        this.zuchuDate = zuchuDate;
    }

    public Timestamp getPlanReturnDate() {
        return planReturnDate;
    }

    public void setPlanReturnDate(Timestamp planReturnDate) {
        this.planReturnDate = planReturnDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Integer getGetCar() {
        return getCar;
    }

    public void setGetCar(Integer getCar) {
        this.getCar = getCar;
    }

    public Integer getReturnCar() {
        return returnCar;
    }

    public void setReturnCar(Integer returnCar) {
        this.returnCar = returnCar;
    }
}
