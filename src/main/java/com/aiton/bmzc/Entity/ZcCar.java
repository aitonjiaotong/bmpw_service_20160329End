package com.aiton.bmzc.Entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午1:45
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class ZcCar {
    private String licensePlate;//牌号
    private String model;//品牌
    private String type;//型号
    private String box;//厢数
    private String pailiang;//排量
    private Integer seat;//乘客数量
    private Integer zidong;//0:自动 1:手动
    private String color;
    private String engineCode;//发动机编号
    private Double mileage;//里程
    private Double maintenanceMileage;//保养里程
    private Integer status;//0:空闲 1：出租 2：停租
    private Double deposit;//押金
    private String buyDate;//购买时间
    private String inspection; //年检日期
    private String image;
    private String note;//备注
    private Integer planId;
    private Integer lei;//车辆类型，0：经济型 1：舒适型 2：豪华型
    @Id
    @Column
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    @Column
    @Basic
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Basic
    @Column
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
    @Basic
    @Column
    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
    @Basic
    @Column
    public Integer getZidong() {
        return zidong;
    }

    public void setZidong(Integer zidong) {
        this.zidong = zidong;
    }

    @Basic
    @Column
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Column
    @Basic
    public String getEngineCode() {
        return engineCode;
    }

    public void setEngineCode(String engineCode) {
        this.engineCode = engineCode;
    }
    @Basic
    @Column
    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }
    @Basic
    @Column
    public Double getMaintenanceMileage() {
        return maintenanceMileage;
    }

    public void setMaintenanceMileage(Double maintenanceMileage) {
        this.maintenanceMileage = maintenanceMileage;
    }
    @Basic
    @Column
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Basic
    @Column
    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }
    @Column
    @Basic
    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }
    @Basic
    @Column
    public String getInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }
    @Basic
    @Column
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Basic
    @Column
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    @Basic
    @Column
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
    @Basic
    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Basic
    @Column
    public Integer getLei() {
        return lei;
    }

    public void setLei(Integer lei) {
        this.lei = lei;
    }
}
