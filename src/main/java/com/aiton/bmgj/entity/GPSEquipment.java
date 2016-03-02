package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * GPS设备类型：ID，公交ID，IP地址，
 *             类型，备注，经度，纬度；
 * d by user on 2016/3/2.
 */
@Entity
@Table
public class GPSEquipment {
    private Integer equipmentId;
    private Integer busId;
    private String ipAddr;
    private Integer type;
    private String mark;
    private String longitude;
    private String latitude;

    @Id
    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Column
    @Basic
    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    @Column
    @Basic
    public String getIPaddr() {
        return ipAddr;
    }

    public void setIPaddr(String ipAddr) {
        this.ipAddr = ipAddr;
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
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Column
    @Basic
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Column
    @Basic
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
