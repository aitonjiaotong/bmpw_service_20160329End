package com.aiton.bmdc.entity.global;

import javax.persistence.*;
import java.util.Date;

/**
 * 消费明细类
 * Created by user on 2016/3/17.
 */
@Entity
@Table
public class SpendDetail {
    private Integer id;
    /**消费金额*/
    private Double spend;
    /**消费类型（0票务；1租车；2打车；3代驾）*/
    private Integer type;
    /**钱包ID*/
    private Integer wallet_id;
    /**消费时间*/
    private Date spend_date;
    /**描述*/
    private String describe;

    @Id
    @Column
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    @Basic
    public Double getSpend() {
        return spend;
    }

    public void setSpend(Double spend) {
        this.spend = spend;
    }

    @Column
    @Basic
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column
    @Basic
    public Integer getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(Integer wallet_id) {
        this.wallet_id = wallet_id;
    }

    @Column
    @Basic
    public Date getSpend_date() {
        return spend_date;
    }

    public void setSpend_date(Date spend_date) {
        this.spend_date = spend_date;
    }

    @Column
    @Basic
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
