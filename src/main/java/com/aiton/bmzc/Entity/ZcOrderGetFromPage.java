package com.aiton.bmzc.Entity;

import java.sql.Timestamp;

/**
 * 用于接收添加order页面传过来的值
 * Created by user on 2016/3/23.
 */
public class ZcOrderGetFromPage {
    private Integer id;
    private Integer carId;//车辆编号
    private Integer planId;     //租赁计划id(防止车辆绑定plan更改,或者不使用车辆绑定plan)
    private String zuchuDate; //租出时间
    private String huancheDate; //还车时间
    private String planReturnDate;//计划还车时间
    private Double limitMileage;//限制里程数
    private Integer accountId;//租车人id
    private Integer guarantorId;//担保人id
    private Double beforeMileage;//开始里程数
    private Double afterMileage;//结束里程数
    private Integer jijiatime;//计价时间
    private Double timePrice;//计时租金
    private Double outMileagePrice;//超程租金
    private Double outTimePrice;//超时租金
    private Double zuPrice;//应收租金
    private Double shouyajin;//实收押金
    private Double price;//总价
    private String note;//备注
    private Integer flag;//订单状态 0:进行中 1：完成 2:取消 3：等待结算
    private Integer driverId;
    private Integer hasDriver;//是否带司机 0:带司机 1：不带司机
    private Integer getCar;//取车地点
    private Integer returnCar;//还车地点
    private Double advancePayment;//预付款
    private Timestamp date;//下单时间
    private Integer status;//0：企业租车 1；个人租车
    private Double insurance;//保险金额
    private String sale;//收款人账号
    private String institutionsCode;//企业账号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getZuchuDate() {
        return zuchuDate;
    }

    public void setZuchuDate(String zuchuDate) {
        this.zuchuDate = zuchuDate;
    }

    public String getHuancheDate() {
        return huancheDate;
    }

    public void setHuancheDate(String huancheDate) {
        this.huancheDate = huancheDate;
    }

    public String getPlanReturnDate() {
        return planReturnDate;
    }

    public void setPlanReturnDate(String planReturnDate) {
        this.planReturnDate = planReturnDate;
    }

    public Double getLimitMileage() {
        return limitMileage;
    }

    public void setLimitMileage(Double limitMileage) {
        this.limitMileage = limitMileage;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getGuarantorId() {
        return guarantorId;
    }

    public void setGuarantorId(Integer guarantorId) {
        this.guarantorId = guarantorId;
    }

    public Double getBeforeMileage() {
        return beforeMileage;
    }

    public void setBeforeMileage(Double beforeMileage) {
        this.beforeMileage = beforeMileage;
    }

    public Double getAfterMileage() {
        return afterMileage;
    }

    public void setAfterMileage(Double afterMileage) {
        this.afterMileage = afterMileage;
    }

    public Integer getJijiatime() {
        return jijiatime;
    }

    public void setJijiatime(Integer jijiatime) {
        this.jijiatime = jijiatime;
    }

    public Double getTimePrice() {
        return timePrice;
    }

    public void setTimePrice(Double timePrice) {
        this.timePrice = timePrice;
    }

    public Double getOutMileagePrice() {
        return outMileagePrice;
    }

    public void setOutMileagePrice(Double outMileagePrice) {
        this.outMileagePrice = outMileagePrice;
    }

    public Double getOutTimePrice() {
        return outTimePrice;
    }

    public void setOutTimePrice(Double outTimePrice) {
        this.outTimePrice = outTimePrice;
    }

    public Double getZuPrice() {
        return zuPrice;
    }

    public void setZuPrice(Double zuPrice) {
        this.zuPrice = zuPrice;
    }

    public Double getShouyajin() {
        return shouyajin;
    }

    public void setShouyajin(Double shouyajin) {
        this.shouyajin = shouyajin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getHasDriver() {
        return hasDriver;
    }

    public void setHasDriver(Integer hasDriver) {
        this.hasDriver = hasDriver;
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

    public Double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(Double advancePayment) {
        this.advancePayment = advancePayment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getInstitutionsCode() {
        return institutionsCode;
    }

    public void setInstitutionsCode(String institutionsCode) {
        this.institutionsCode = institutionsCode;
    }
}
