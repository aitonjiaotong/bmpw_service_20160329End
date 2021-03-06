package com.aiton.bmzc.entity;

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
    private Integer carId;//车辆编号
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
    private Integer flag;//订单状态 0:进行中 1：完成 2:取消 3：等待结算(已还车)
    private Integer driverId;
    private Integer hasDriver;//是否带司机 0:带司机 1：不带司机
    private Integer getCar;//取车地点
    private Integer returnCar;//还车地点
    private Double advancePayment;//预付款
    private Timestamp date;//下单时间
    private Integer status;//0：企业租车 1；个人租车
    private String sale;//收款人账号
    private String institutionsCode;//企业账号
    private Integer hasFranchiseFees;//是否包含不计免赔费用
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
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
    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
    @Basic
    @Column
    public String getInstitutionsCode() {
        return institutionsCode;
    }

    public void setInstitutionsCode(String institutionsCode) {
        this.institutionsCode = institutionsCode;
    }
    @Column
    @Basic
    public Integer getHasFranchiseFees() {
        return hasFranchiseFees;
    }

    public void setHasFranchiseFees(Integer hasFranchiseFees) {
        this.hasFranchiseFees = hasFranchiseFees;
    }

    @Override
    public String toString() {
        return "ZcOrder{" +
                "id=" + id +
                ", carId=" + carId +
                ", planId=" + planId +
                ", zuchuDate=" + zuchuDate +
                ", huancheDate=" + huancheDate +
                ", planReturnDate=" + planReturnDate +
                ", limitMileage=" + limitMileage +
                ", accountId=" + accountId +
                ", guarantorId=" + guarantorId +
                ", beforeMileage=" + beforeMileage +
                ", afterMileage=" + afterMileage +
                ", jijiatime=" + jijiatime +
                ", timePrice=" + timePrice +
                ", outMileagePrice=" + outMileagePrice +
                ", outTimePrice=" + outTimePrice +
                ", zuPrice=" + zuPrice +
                ", shouyajin=" + shouyajin +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", flag=" + flag +
                ", driverId=" + driverId +
                ", hasDriver=" + hasDriver +
                ", getCar=" + getCar +
                ", returnCar=" + returnCar +
                ", advancePayment=" + advancePayment +
                ", date=" + date +
                ", status=" + status +
                ", sale='" + sale + '\'' +
                ", institutionsCode='" + institutionsCode + '\'' +
                ", hasFranchiseFees=" + hasFranchiseFees +
                '}';
    }

    public ZcOrder(){}

    public ZcOrder(Integer id, Integer carId, Integer planId,
                   Timestamp zuchuDate, Timestamp huancheDate,
                   Timestamp planReturnDate, Double limitMileage,
                   Integer accountId, Integer guarantorId,
                   Double beforeMileage, Double afterMileage,
                   Integer jijiatime, Double timePrice, Double
                   outMileagePrice, Double outTimePrice,
                   Double zuPrice, Double shouyajin, Double price,
                   String note, Integer flag, Integer driverId,
                   Integer hasDriver, Integer getCar, Integer returnCar,
                   Double advancePayment, Timestamp date,
                   Integer status, Double insurance,
                   String sale, String institutionsCode,Integer hasFranchiseFees) {
        this.id = id;
        this.carId = carId;
        this.planId = planId;
        this.zuchuDate = zuchuDate;
        this.huancheDate = huancheDate;
        this.planReturnDate = planReturnDate;
        this.limitMileage = limitMileage;
        this.accountId = accountId;
        this.guarantorId = guarantorId;
        this.beforeMileage = beforeMileage;
        this.afterMileage = afterMileage;
        this.jijiatime = jijiatime;
        this.timePrice = timePrice;
        this.outMileagePrice = outMileagePrice;
        this.outTimePrice = outTimePrice;
        this.zuPrice = zuPrice;
        this.shouyajin = shouyajin;
        this.price = price;
        this.note = note;
        this.flag = flag;
        this.driverId = driverId;
        this.hasDriver = hasDriver;
        this.getCar = getCar;
        this.returnCar = returnCar;
        this.advancePayment = advancePayment;
        this.date = date;
        this.status = status;
        this.sale = sale;
        this.institutionsCode = institutionsCode;
        this.hasFranchiseFees=hasFranchiseFees;
    }
    public ZcOrder(ZcOrderGetFromPage page) {
        this.id = page.getId();
        this.carId = page.getCarId();
        this.planId = page.getPlanId();
       /*
        * 类型转换
        * private String zuchuDate; //租出时间
        * private String huancheDate; //还车时间
        * private String planReturnDate;//计划还车时间
        * private String date;//下单时间
        * */
        this.zuchuDate = Timestamp.valueOf(page.getZuchuDate());
        this.huancheDate = null;
        this.planReturnDate = Timestamp.valueOf(page.getPlanReturnDate());
        this.limitMileage = page.getLimitMileage();
        this.accountId = page.getAccountId();
        this.guarantorId = page.getGuarantorId();
        this.beforeMileage = page.getBeforeMileage();
        this.afterMileage = page.getAfterMileage();
        this.jijiatime = page.getJijiatime();
        this.timePrice = page.getTimePrice();
        this.outMileagePrice = page.getOutMileagePrice();
        this.outTimePrice = page.getOutTimePrice();
        this.zuPrice = page.getZuPrice();
        this.shouyajin = page.getShouyajin();
        this.price = page.getPrice();
        this.note = page.getNote();
        this.flag = page.getFlag();
        this.driverId = page.getDriverId();
        this.hasDriver = page.getHasDriver();
        this.getCar = page.getGetCar();
        this.returnCar = page.getReturnCar();
        this.advancePayment = page.getAdvancePayment();
        this.date = new Timestamp(System.currentTimeMillis());
        this.status = page.getStatus();
        this.sale = page.getSale();
        this.institutionsCode = page.getInstitutionsCode();
        this.hasFranchiseFees=page.getHasFranchiseFees();
    }
}
