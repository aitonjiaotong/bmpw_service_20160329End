package com.aiton.bmdc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 打车订单类型：ID，用户ID，订单实际金额，
 *              订单生成时间，订单取消时间，
 *              订单完成时间，出发地，目的地，
 *              用户手机，订单状态，
 *              是否发送短信通知，接单司机ID,
 *              订单开始执行经度，订单开始执行纬度，
 *              订单结束执行经度，订单结束执行纬度，
 *              订单开始执行时间（上车），订单结束执行时间（到达），
 *              异常标志位，异常描述。
 * Created by user on 2016/3/17.
 */
@Entity
@Table
public class DCOrder {
    private Integer order_id;
    /**用户ID*/
    private Integer account_id;
    /**订单实际金额*/
    private Double order_price;
    /**订单生成时间*/
    private Date order_begin_date;
    /**订单取消时间*/
    private Date order_cancle_date;
    /**订单完成时间*/
    private Date order_complate_date;
    /**出发地*/
    private String order_from_address;
    /**目的地*/
    private String order_to_address;
    /**用户手机*/
    private String user_phone;
    /**订单状态(0等待接单；1已接单未执行；2在执行中；3执行完毕等待支付；4已支付)*/
    private Integer status;
    /**是否发送短信通知*/
    private Integer is_notice;
    /**接单司机ID*/
    private Integer driver_id;
    /**订单开始执行经度*/
    private Double beginExecuteLongitude;
    /**订单开始执行纬度*/
    private Double beginExecuteLatitude;
    /**订单结束执行经度*/
    private Double endExecuteLongitude;
    /**订单结束执行纬度*/
    private Double endExecuteLatitude;
    /**订单开始执行时间（上车）*/
    private Date beginExecuteDate;
    /**订单结束执行时间（到达）*/
    private Date endExecuteDate;
    /**异常标志位（0正常；1异常）*/
    private Integer exception_status;
    /**异常描述*/
    private String exception_describe;

    @Id
    @Column
    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    @Column
    @Basic
    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    @Column
    @Basic
    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }

    @Column
    @Basic
    public Date getOrder_begin_date() {
        return order_begin_date;
    }

    public void setOrder_begin_date(Date order_begin_date) {
        this.order_begin_date = order_begin_date;
    }

    @Column
    @Basic
    public Date getOrder_cancle_date() {
        return order_cancle_date;
    }

    public void setOrder_cancle_date(Date order_cancle_date) {
        this.order_cancle_date = order_cancle_date;
    }

    @Column
    @Basic
    public Date getOrder_complate_date() {
        return order_complate_date;
    }

    public void setOrder_complate_date(Date order_complate_date) {
        this.order_complate_date = order_complate_date;
    }

    @Column
    @Basic
    public String getOrder_from_address() {
        return order_from_address;
    }

    public void setOrder_from_address(String order_from_address) {
        this.order_from_address = order_from_address;
    }

    @Column
    @Basic
    public String getOrder_to_address() {
        return order_to_address;
    }

    public void setOrder_to_address(String order_to_address) {
        this.order_to_address = order_to_address;
    }

    @Column
    @Basic
    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    @Column
    @Basic
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column
    @Basic
    public Integer getIs_notice() {
        return is_notice;
    }

    public void setIs_notice(Integer is_notice) {
        this.is_notice = is_notice;
    }

    @Column
    @Basic
    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }

    @Column
    @Basic
    public Double getBeginExecuteLongitude() {
        return beginExecuteLongitude;
    }

    public void setBeginExecuteLongitude(Double beginExecuteLongitude) {
        this.beginExecuteLongitude = beginExecuteLongitude;
    }

    @Column
    @Basic
    public Double getBeginExecuteLatitude() {
        return beginExecuteLatitude;
    }

    public void setBeginExecuteLatitude(Double beginExecuteLatitude) {
        this.beginExecuteLatitude = beginExecuteLatitude;
    }

    @Column
    @Basic
    public Double getEndExecuteLongitude() {
        return endExecuteLongitude;
    }

    public void setEndExecuteLongitude(Double endExecuteLongitude) {
        this.endExecuteLongitude = endExecuteLongitude;
    }

    @Column
    @Basic
    public Double getEndExecuteLatitude() {
        return endExecuteLatitude;
    }

    public void setEndExecuteLatitude(Double endExecuteLatitude) {
        this.endExecuteLatitude = endExecuteLatitude;
    }

    @Column
    @Basic
    public Date getBeginExecuteDate() {
        return beginExecuteDate;
    }

    public void setBeginExecuteDate(Date beginExecuteDate) {
        this.beginExecuteDate = beginExecuteDate;
    }

    @Column
    @Basic
    public Date getEndExecuteDate() {
        return endExecuteDate;
    }

    public void setEndExecuteDate(Date endExecuteDate) {
        this.endExecuteDate = endExecuteDate;
    }

    @Column
    @Basic
    public Integer getException_status() {
        return exception_status;
    }

    public void setException_status(Integer exception_status) {
        this.exception_status = exception_status;
    }

    @Column
    @Basic
    public String getException_describe() {
        return exception_describe;
    }

    public void setException_describe(String exception_describe) {
        this.exception_describe = exception_describe;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj) return true;
        if (obj instanceof DCOrder){
            DCOrder order = (DCOrder) obj;
            return (order.getOrder_id()).equals(this.order_id);
        }
        return false;
    }
}
