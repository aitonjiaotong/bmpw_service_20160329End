package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * 公交车类型：ID，名称，金额，始发站，终到站；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class Bus {
    private Integer busId;
    private String busName;
    private Double price;
    /**始发站*/
    private String start;
    /**终到站*/
    private String end;

    @Id
    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    @Column
    @Basic
    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
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
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Column
    @Basic
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
