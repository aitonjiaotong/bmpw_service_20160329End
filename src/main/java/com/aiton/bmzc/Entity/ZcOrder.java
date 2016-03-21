package com.aiton.bmzc.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午2:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class ZcOrder {
    private Integer id;
    private String licensePlate;//车牌号
    private Integer planId;     //租赁计划id(防止车辆绑定plan更改,或者不使用车辆绑定plan)
    private Timestamp zuchuDate; //租出时间
    private Timestamp huancheDate; //还车时间
    private Timestamp planReturnDate;//计划还车时间
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
    private Integer flag;//订单状态 0:进行中 1：完成 2:取消
    private Integer driverId;
    private Integer hasDriver;//是否带司机 0:带司机 1：不带司机
    private Integer getCar;//取车地点
    private Integer returnCar;//还车地点
    private Double advancePayment;//预付款
    private Timestamp date;//下单时间
    private Integer status;//0：企业租车 1；个人租车
    private Double insurance;//保险金额
    private String sale;//收款人账号
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column
    @Basic
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    @Column
    @Basic
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
    @Basic
    @Column
    public Timestamp getZuchuDate() {
        return zuchuDate;
    }

    public void setZuchuDate(Timestamp zuchuDate) {
        this.zuchuDate = zuchuDate;
    }
    @Basic
    @Column
    public Timestamp getHuancheDate() {
        return huancheDate;
    }

    public void setHuancheDate(Timestamp huancheDate) {
        this.huancheDate = huancheDate;
    }
    @Basic
    @Column
    public Timestamp getPlanReturnDate() {
        return planReturnDate;
    }

    public void setPlanReturnDate(Timestamp planReturnDate) {
        this.planReturnDate = planReturnDate;
    }
    @Basic
    @Column
    public Double getLimitMileage() {
        return limitMileage;
    }

    public void setLimitMileage(Double limitMileage) {
        this.limitMileage = limitMileage;
    }
    @Basic
    @Column
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column
    public Double getBeforeMileage() {
        return beforeMileage;
    }

    public void setBeforeMileage(Double beforeMileage) {
        this.beforeMileage = beforeMileage;
    }
    @Basic
    @Column
    public Double getAfterMileage() {
        return afterMileage;
    }

    public void setAfterMileage(Double afterMileage) {
        this.afterMileage = afterMileage;
    }
    @Basic
    @Column
    public Double getTimePrice() {
        return timePrice;
    }

    public void setTimePrice(Double timePrice) {
        this.timePrice = timePrice;
    }
    @Basic
    @Column
    public Double getOutMileagePrice() {
        return outMileagePrice;
    }

    public void setOutMileagePrice(Double outMileagePrice) {
        this.outMileagePrice = outMileagePrice;
    }
    @Basic
    @Column
    public Double getZuPrice() {
        return zuPrice;
    }

    public void setZuPrice(Double zuPrice) {
        this.zuPrice = zuPrice;
    }
    @Basic
    @Column
    public Double getShouyajin() {
        return shouyajin;
    }

    public void setShouyajin(Double shouyajin) {
        this.shouyajin = shouyajin;
    }
    @Basic
    @Column
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    @Basic
    @Column

    public Integer getJijiatime() {
        return jijiatime;
    }

    public void setJijiatime(Integer jijiatime) {
        this.jijiatime = jijiatime;
    }
    @Basic
    @Column
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
    @Basic
    @Column
    public Integer getGuarantorId() {
        return guarantorId;
    }

    public void setGuarantorId(Integer guarantorId) {
        this.guarantorId = guarantorId;
    }
    @Column
    @Basic
    public Integer getHasDriver() {
        return hasDriver;
    }

    public void setHasDriver(Integer hasDriver) {
        this.hasDriver = hasDriver;
    }
    @Basic
    @Column
    public Integer getGetCar() {
        return getCar;
    }

    public void setGetCar(Integer getCar) {
        this.getCar = getCar;
    }
    @Basic
    @Column
    public Integer getReturnCar() {
        return returnCar;
    }

    public void setReturnCar(Integer returnCar) {
        this.returnCar = returnCar;
    }
    @Basic
    @Column
    public Double getOutTimePrice() {
        return outTimePrice;
    }

    public void setOutTimePrice(Double outTimePrice) {
        this.outTimePrice = outTimePrice;
    }
    @Basic
    @Column
    public Double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(Double advancePayment) {
        this.advancePayment = advancePayment;
    }
    @Column
    @Basic

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    @Column
    @Basic
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    @Basic
    @Column
    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }
    @Basic
    @Column
    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}
