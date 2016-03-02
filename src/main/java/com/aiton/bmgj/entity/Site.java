package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * 站点类型：ID,名称，经度，纬度，备注；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class Site {
    private Integer siteId;
    private String siteName;
    /**GPS:经度*/
    private String longitude;
    /**GPS:纬度*/
    private String latitude;
    private String mark;
    @Id
    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
    @Column
    @Basic
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
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
    @Column
    @Basic
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
