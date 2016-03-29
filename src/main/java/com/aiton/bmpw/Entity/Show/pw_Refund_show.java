package com.aiton.bmpw.entity.show;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午9:04
 * To change this template use File | Settings | File Templates.
 */
public class pw_Refund_show {
    private String bookLogAID;
    private String phone;
    private Double price;//票价
    private Double redfund;//退款金额
    private Integer flag;//处理标记位 0:已处理 1：未处理
    private Timestamp clsj;//处理时间

    public String getBookLogAID() {
        return bookLogAID;
    }

    public void setBookLogAID(String bookLogAID) {
        this.bookLogAID = bookLogAID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRedfund() {
        return redfund;
    }

    public void setRedfund(Double redfund) {
        this.redfund = redfund;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Timestamp getClsj() {
        return clsj;
    }

    public void setClsj(Timestamp clsj) {
        this.clsj = clsj;
    }
}
