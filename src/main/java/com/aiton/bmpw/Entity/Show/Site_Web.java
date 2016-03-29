package com.aiton.bmpw.entity.show;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-24
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public class Site_Web {
    private Integer SiteID;
    private String SiteCode;
    private String SiteName;
    private String ZoneID;
    private String ZoneName;

    public Integer getSiteID() {
        return SiteID;
    }

    public void setSiteID(Integer siteID) {
        SiteID = siteID;
    }

    public String getSiteCode() {
        return SiteCode;
    }

    public void setSiteCode(String siteCode) {
        SiteCode = siteCode;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getZoneID() {
        return ZoneID;
    }

    public void setZoneID(String zoneID) {
        ZoneID = zoneID;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public void setZoneName(String zoneName) {
        ZoneName = zoneName;
    }
}
