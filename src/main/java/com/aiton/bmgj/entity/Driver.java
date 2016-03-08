package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * 驾驶员类型：线路ID，驾驶员ID，
 *            驾驶员姓名，在职职工工号，
 *            考勤卡卡号；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class Driver {
    private Integer id;
    private Integer busline_id;
    private Integer driver_id;
    private String driver_name;
    /**在职职工工号*/
    private String driver_no;
    /**考勤卡卡号*/
    private String card_no;

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
    public String getDriver_no() {
        return driver_no;
    }

    public void setDriver_no(String driver_no) {
        this.driver_no = driver_no;
    }

    @Column
    @Basic
    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }
}
