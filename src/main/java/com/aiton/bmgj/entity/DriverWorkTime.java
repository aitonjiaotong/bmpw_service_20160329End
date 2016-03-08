package com.aiton.bmgj.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 驾驶员考勤:线路ID，驾驶员ID，驾驶员姓名，
 *           车辆ID，车牌号，签到时间，签退时间；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class DriverWorkTime {
    private Integer id;
    private Integer busline_id;
    private Integer driver_id;
    private String driver_name;
    private Integer car_id;
    /**车牌号*/
    private String car_no;
    /**签到时间，格式：YYYY-MM-DD HH24:MI:SS*/
    private Date login_time;
    /**签退时间，格式：YYYY-MM-DD HH24:MI:SS*/
    private Date logout_time;
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
    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    @Column
    @Basic
    public Date getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Date logout_time) {
        this.logout_time = logout_time;
    }
}
