package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * 公交车类型：车辆ID，线路ID，车牌号，设备ID；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class Bus {
    private Integer id;
    /**线路ID*/
    private Integer busline_id;
    /**车辆ID*/
    private Integer car_id;
    /**车牌号*/
    private String car_no;
    /**设备ID*/
    private String dev_id;

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
    public Integer getBusline_id() {
        return busline_id;
    }

    public void setBusline_id(Integer busline_id) {
        this.busline_id = busline_id;
    }

    @Column(unique = true)
    @Basic
    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    @Column
    @Basic
    public String getCar_no() {
        return car_no;
    }

    public void setCar_no(String car_no) {
        this.car_no = car_no;
    }

    @Column
    @Basic
    public String getDev_id() {
        return dev_id;
    }

    public void setDev_id(String dev_id) {
        this.dev_id = dev_id;
    }
}
