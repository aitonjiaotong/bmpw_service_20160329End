package com.aiton.bmpw.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-5
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;

/**
 *站点
 */
@Entity
@Table
public class Site {
    private Integer SiteID;
    private String SiteCode;
    private String SiteName;
    private Integer ZoneID;
    private String ZoneName;
    private Integer flag;//标志位 0：显示 1：不显示
    @Id
    @Column
    public Integer getSiteID() {
        return SiteID;
    }

    public void setSiteID(Integer siteID) {
        SiteID = siteID;
    }
    @Basic
    @Column
    public String getSiteCode() {
        return SiteCode;
    }

    public void setSiteCode(String siteCode) {
        SiteCode = siteCode;
    }
    @Basic
    @Column
    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }
    @Basic
    @Column
    public Integer getZoneID() {
        return ZoneID;
    }

    public void setZoneID(Integer zoneID) {
        ZoneID = zoneID;
    }
    @Basic
    @Column
    public String getZoneName() {
        return ZoneName;
    }

    public void setZoneName(String zoneName) {
        ZoneName = zoneName;
    }
    @Basic
    @Column
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
