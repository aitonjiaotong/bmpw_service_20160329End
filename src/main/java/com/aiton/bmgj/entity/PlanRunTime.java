package com.aiton.bmgj.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 计划班次：线路ID，发车时间，车辆ID，车牌号
 *          驾驶员ID，驾驶员姓名；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class PlanRunTime {
    private Integer id;
    private Integer busline_id;
    /**发车时间，格式：HH24:MI*/
    private Date stime;
    private Integer car_id;
    /**车牌号*/
    private String car_no;
    private Integer driver_id;
    private String driver_name;
    /**上下行，1：上行 ；2：下行*/
    private Integer UpDown;

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
    public Integer getUpDown() {
        return UpDown;
    }

    public void setUpDown(Integer upDown) {
        UpDown = upDown;
    }

    @Column
    @Basic
    public Integer getBusline_id() {
        return busline_id;
    }

    public void setBusline_id(Integer busline_id) {
        this.busline_id = busline_id;
    }

    @Column
    @Basic
    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    @Column
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
    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }

    @Column
    @Basic
    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }
}
