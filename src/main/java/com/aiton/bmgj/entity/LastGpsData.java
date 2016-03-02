package com.aiton.bmgj.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 车辆末次位置信息：线路ID,车辆ID，
 *                  车牌号，GPS时间，经度，纬度，
 *                  高度，速度，方向；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class LastGpsData {
    private Integer busline_id;
    private Integer car_id;
    private String car_no;
    /**最后一次GPS的时间，格式：YYYY-MM-DD HH24:MI:SS*/
    private Date gps_time;
    /**经度，乘于10的6次方*/
    private Integer lng;
    /**经度，乘于10的6次方*/
    private Integer lat;
    /**高度，乘于10的2次方*/
    private Integer hight;
    /**速度，乘于10的4次方*/
    private Integer speed;
    /**方向，乘于10的2次方*/
    private Integer direct;

    @Id
    public Integer getBusline_id() {
        return busline_id;
    }

    public void setBusline_id(Integer busline_id) {
        this.busline_id = busline_id;
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
    public Date getGps_time() {
        return gps_time;
    }

    public void setGps_time(Date gps_time) {
        this.gps_time = gps_time;
    }

    @Column
    @Basic
    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    @Column
    @Basic
    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
    }

    @Column
    @Basic
    public Integer getHight() {
        return hight;
    }

    public void setHight(Integer hight) {
        this.hight = hight;
    }

    @Column
    @Basic
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Column
    @Basic
    public Integer getDirect() {
        return direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }
}
