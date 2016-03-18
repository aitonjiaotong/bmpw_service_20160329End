package com.aiton.bmdc.entity;

import javax.persistence.*;

/**
 * 打车评价表：ID，司机ID，乘客ID，
 *            满意度，评价内容；
 * Created by user on 2016/3/17.
 */
@Entity
@Table
public class DCEvaluate {
    private Integer id;
    /**司机ID*/
    private Integer driver_id;
    /**乘客ID*/
    private Integer account_id;
    /**满意度*/
    private Integer satisfaction;
    /**评价内容*/
    private String evaluate;

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
    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
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
    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    @Column
    @Basic
    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}
