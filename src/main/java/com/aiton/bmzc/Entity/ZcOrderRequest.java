package com.aiton.bmzc.Entity;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 上午8:40
 * To change this template use File | Settings | File Templates.
 */
public class ZcOrderRequest {
    private String model;//品牌
    private String type;//型号
    private String box;//厢数
    private String pailiang;//排量
    private Integer seat;//乘客数量
    private Integer zidong;//0:自动 1:手动
    private Integer plan_id;//租赁计划id
    private Long zuchuDate; //租出时间
    private Long planReturnDate;//计划还车时间
    private Double price;//总价
    private Integer status;//0：企业租车 1；个人租车
    private Double insurance;//保险金额
    private Integer getCar;//取车地点
    private Integer returnCar;//还车地点
    private Integer hasDriver;//0:带 1：不带
    private Integer driverId;
    private Integer carId;
    private Integer lei;
    private String institutionsCode;
    private Integer accountId;
    private Integer hasFranchiseFees;//是否包含不计免赔费用

    public Integer getHasFranchiseFees() {
        return hasFranchiseFees;
    }

    public void setHasFranchiseFees(Integer hasFranchiseFees) {
        this.hasFranchiseFees = hasFranchiseFees;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getLei() {
        return lei;
    }

    public void setLei(Integer lei) {
        this.lei = lei;
    }

    public String getInstitutionsCode() {
        return institutionsCode;
    }

    public void setInstitutionsCode(String institutionsCode) {
        this.institutionsCode = institutionsCode;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getPailiang() {
        return pailiang;
    }

    public void setPailiang(String pailiang) {
        this.pailiang = pailiang;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getZidong() {
        return zidong;
    }

    public void setZidong(Integer zidong) {
        this.zidong = zidong;
    }

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
    }

    public Long getZuchuDate() {
        return zuchuDate;
    }

    public void setZuchuDate(Long zuchuDate) {
        this.zuchuDate = zuchuDate;
    }

    public Long getPlanReturnDate() {
        return planReturnDate;
    }

    public void setPlanReturnDate(Long planReturnDate) {
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

    public Integer getHasDriver() {
        return hasDriver;
    }

    public void setHasDriver(Integer hasDriver) {
        this.hasDriver = hasDriver;
    }

    @Override
    public String toString() {
        return "ZcOrderRequest{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", box='" + box + '\'' +
                ", pailiang='" + pailiang + '\'' +
                ", seat=" + seat +
                ", zidong=" + zidong +
                ", plan_id=" + plan_id +
                ", zuchuDate=" + zuchuDate +
                ", planReturnDate=" + planReturnDate +
                ", price=" + price +
                ", status=" + status +
                ", insurance=" + insurance +
                ", getCar=" + getCar +
                ", returnCar=" + returnCar +
                ", hasDriver=" + hasDriver +
                ", driverId=" + driverId +
                ", carId=" + carId +
                ", lei=" + lei +
                ", institutionsCode='" + institutionsCode + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
