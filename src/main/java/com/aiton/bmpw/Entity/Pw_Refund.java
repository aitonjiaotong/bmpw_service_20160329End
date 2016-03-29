package com.aiton.bmpw.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午8:37
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 退票表
 */
@Entity
@Table
public class Pw_Refund {
    private String bookLogAID;
    private Double price;//票价
    private Double redfund;//退款金额
    private Integer flag;//处理标记位 0:已处理 1：未处理
    private String phone;
    private Timestamp clsj;//处理时间
    private String orderNum;//订单流水号
    @Id
    public String getBookLogAID() {
        return bookLogAID;
    }

    public void setBookLogAID(String bookLogAID) {
        this.bookLogAID = bookLogAID;
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
    public Double getRedfund() {
        return redfund;
    }

    public void setRedfund(Double redfund) {
        this.redfund = redfund;
    }
    @Basic
    @Column
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    @Column
    @Basic
    public Timestamp getClsj() {
        return clsj;
    }

    public void setClsj(Timestamp clsj) {
        this.clsj = clsj;
    }
    @Basic
    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Column
    @Basic
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
