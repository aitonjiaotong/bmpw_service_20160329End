package com.aiton.bmgj.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 公交卡类型：ID,卡类型，金额，充值时间,
 *            用户ID，备注；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class BusCard {
    private Integer cardId;
    private Integer cardType;
    private Double price;
    private Date date;
    private Integer userId;
    private String mark;
    @Id
    public Integer getCardId() {
    return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    @Column
    @Basic
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Column
    @Basic
    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    @Column
    @Basic
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column
    @Basic
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Column
    @Basic
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
