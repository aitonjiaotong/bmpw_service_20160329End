package com.aiton.bmpw.Entity;

import javax.persistence.*;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-16
 * Time: 下午5:05
 * To change this template use File | Settings | File Templates.
 */

/**
 * 地区表
 */
@Entity
@Table
public class Zone {
    private Integer ZoneID;
    private Integer ZoneCode;
    private String ZoneName;
    private Integer ParentZoneID;
    private String FullCode;
    private String FullName;
    private String SubZones;
    private Integer flag;//标志位 0：可达目的地 1：可出发地 2：可出发也可以到达 3：不可出发或到达

    @Id
    @Column
    public Integer getZoneID() {
        return ZoneID;
    }

    public void setZoneID(Integer zoneID) {
        ZoneID = zoneID;
    }

    public Integer getZoneCode() {
        return ZoneCode;
    }

    public void setZoneCode(Integer zoneCode) {
        ZoneCode = zoneCode;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public void setZoneName(String zoneName) {
        ZoneName = zoneName;
    }

    public Integer getParentZoneID() {
        return ParentZoneID;
    }

    public void setParentZoneID(Integer parentZoneID) {
        ParentZoneID = parentZoneID;
    }

    public String getFullCode() {
        return FullCode;
    }

    public void setFullCode(String fullCode) {
        FullCode = fullCode;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getSubZones() {
        return SubZones;
    }

    public void setSubZones(String subZones) {
        SubZones = subZones;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
