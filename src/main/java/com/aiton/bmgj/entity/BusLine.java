package com.aiton.bmgj.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * 公交线路：线路ID，线路编号，线路名称，
 *          上行里程，下行里程，运行时长，
 *          上行首班，上行末班，下行首班，
 *          下行末班，基本票价，全程票价；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class BusLine {
    private Integer busline_id;
    private Integer busline_no;
    private String busline_name;
    /**上行里程*/
    private Double course_up;
    /**下行里程*/
    private Double course_down;
    /**运行时长，单位分钟*/
    private Integer run_time;
    /**上行首班，格式：HH24:MI*/
    private Date stime_up;
    /**上行末班，格式：HH24:MI*/
    private Date etime_up;
    /**下行首班，格式：HH24:MI*/
    private Date stime_down;
    /**下行末班，格式：HH24:MI*/
    private Date etime_down;
    /**基本票价*/
    private Double price_base;
    /**全程票价*/
    private Double price_all;

    @Id
    @Column
    public Integer getBusline_id() {
        return busline_id;
    }

    public void setBusline_id(Integer busLine_id) {
        this.busline_id = busLine_id;
    }

    @Column
    @Basic
    public Integer getBusLine_no() {
        return busline_no;
    }

    public void setBusLine_no(Integer busLine_no) {
        this.busline_no = busLine_no;
    }

    @Column
    @Basic
    public String getBusline_name() {
        return busline_name;
    }

    public void setBusline_name(String busline_name) {
        this.busline_name = busline_name;
    }

    @Column
    @Basic
    public Double getCourse_up() {
        return course_up;
    }

    public void setCourse_up(Double course_up) {
        this.course_up = course_up;
    }

    @Column
    @Basic
    public Double getCourse_down() {
        return course_down;
    }

    public void setCourse_down(Double course_down) {
        this.course_down = course_down;
    }

    @Column
    @Basic
    public Integer getRun_time() {
        return run_time;
    }

    public void setRun_time(Integer run_time) {
        this.run_time = run_time;
    }

    @Column
    @Basic
    public Date getStime_up() {
        return stime_up;
    }

    public void setStime_up(Date stime_up) {
        this.stime_up = stime_up;
    }

    @Column
    @Basic
    public Date getEtime_up() {
        return etime_up;
    }

    public void setEtime_up(Date etime_up) {
        this.etime_up = etime_up;
    }

    @Column
    @Basic
    public Date getStime_down() {
        return stime_down;
    }

    public void setStime_down(Date stime_down) {
        this.stime_down = stime_down;
    }

    @Column
    @Basic
    public Date getEtime_down() {
        return etime_down;
    }

    public void setEtime_down(Date etime_down) {
        this.etime_down = etime_down;
    }

    @Column
    @Basic
    public Double getPrice_base() {
        return price_base;
    }

    public void setPrice_base(Double price_base) {
        this.price_base = price_base;
    }

    @Column
    @Basic
    public Double getPrice_all() {
        return price_all;
    }

    public void setPrice_all(Double price_all) {
        this.price_all = price_all;
    }

    @Override
    public String toString() {
        return "BusLine{" +
                "busLine_id=" + busline_id +
                ", busLine_no=" + busline_no +
                ", busline_name='" + busline_name + '\'' +
                ", course_up=" + course_up +
                ", course_down=" + course_down +
                ", run_time=" + run_time +
                ", stime_up=" + stime_up +
                ", etime_up=" + etime_up +
                ", stime_down=" + stime_down +
                ", etime_down=" + etime_down +
                ", price_base=" + price_base +
                ", price_all=" + price_all +
                '}';
    }
}
