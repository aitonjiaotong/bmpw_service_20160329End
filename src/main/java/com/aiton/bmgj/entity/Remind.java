package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * 提醒类型：ID，站点ID，车辆ID，类型，用户ID；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class Remind {
    private Integer remind_id;
    private Integer station_id;
    private Integer car_id;
    private Integer type;
    private Integer user_id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getRemind_id() {
        return remind_id;
    }

    public void setRemind_id(Integer remind_id) {
        this.remind_id = remind_id;
    }

    @Column
    @Basic
    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
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
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column
    @Basic
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
