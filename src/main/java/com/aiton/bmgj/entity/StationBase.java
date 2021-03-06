package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * 站点基础信息：ID,名称，经度，
 *              纬度,名称首字母
 * Created by user on 2016/3/4.
 */
@Entity
@Table
public class StationBase {
    private Integer id;
    private Integer station_id;
    private String station_name;
    /**经度,乘以10的六次方*/
    private Integer lng;
    /**纬度,乘以10的六次方*/
    private Integer lat;
    /**名称首字母*/
    private String chineseFirstLetter;

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
    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

    @Column
    @Basic
    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
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
    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    @Column
    @Basic
    public String getChineseFirstLetter() {
        return chineseFirstLetter;
    }

    public void setChineseFirstLetter(String chineseFirstLetter) {
        this.chineseFirstLetter = chineseFirstLetter;
    }
}
