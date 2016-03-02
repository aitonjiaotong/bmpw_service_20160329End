package com.aiton.bmpw.Entity.Show;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-23
 * Time: 上午10:10
 * To change this template use File | Settings | File Templates.
 */
public class Zone_Web {
    private Integer ZoneID;
    private Integer ZoneCode;
    private String ZoneName;
    private Integer ParentZoneID;
    private String FullCode;
    private String FullName;
    private List<Zone_Web> SubZones;

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

    public List<Zone_Web> getSubZones() {
        return SubZones;
    }

    public void setSubZones(List<Zone_Web> subZones) {
        SubZones = subZones;
    }
}
