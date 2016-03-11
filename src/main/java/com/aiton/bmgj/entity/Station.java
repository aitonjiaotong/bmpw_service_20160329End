package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * 线路站点类型：线路ID，上下行，站点序号，
 *          站点ID；
 * 注意：这个类是线路和站点绑定不重复，单独是可重复的！
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    /**线路ID*/
    private Integer busline_id;
    /**上下行：1=上行，2=下行*/
    private Integer up_down;
    /**站点序号，从1开始*/
    private Integer station_index;
    private Integer station_id;

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
    public Integer getUp_down() {
        return up_down;
    }

    public void setUp_down(Integer up_down) {
        this.up_down = up_down;
    }

    @Column
    @Basic
    public Integer getStation_index() {
        return station_index;
    }

    public void setStation_index(Integer station_index) {
        this.station_index = station_index;
    }


    @Column
    @Basic
    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

}
