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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zone)) return false;

        Zone zone = (Zone) o;

        if (FullCode != null ? !FullCode.equals(zone.FullCode) : zone.FullCode != null) return false;
        if (FullName != null ? !FullName.equals(zone.FullName) : zone.FullName != null) return false;
        if (ParentZoneID != null ? !ParentZoneID.equals(zone.ParentZoneID) : zone.ParentZoneID != null) return false;
        if (SubZones != null ? !SubZones.equals(zone.SubZones) : zone.SubZones != null) return false;
        if (ZoneCode != null ? !ZoneCode.equals(zone.ZoneCode) : zone.ZoneCode != null) return false;
        if (ZoneID != null ? !ZoneID.equals(zone.ZoneID) : zone.ZoneID != null) return false;
        if (ZoneName != null ? !ZoneName.equals(zone.ZoneName) : zone.ZoneName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ZoneID != null ? ZoneID.hashCode() : 0;
        result = 31 * result + (ZoneCode != null ? ZoneCode.hashCode() : 0);
        result = 31 * result + (ZoneName != null ? ZoneName.hashCode() : 0);
        result = 31 * result + (ParentZoneID != null ? ParentZoneID.hashCode() : 0);
        result = 31 * result + (FullCode != null ? FullCode.hashCode() : 0);
        result = 31 * result + (FullName != null ? FullName.hashCode() : 0);
        result = 31 * result + (SubZones != null ? SubZones.hashCode() : 0);
        return result;
    }
}
