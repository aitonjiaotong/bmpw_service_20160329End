package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * 提醒类型：ID，站点ID，车辆ID，类型，用户ID；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class Remind {
    private Integer remindId;
    private Integer siteId;
    private Integer busId;
    private Integer type;
    private Integer userId;

    @Id
    public Integer getRemindId() {
        return remindId;
    }

    public void setRemindId(Integer remindId) {
        this.remindId = remindId;
    }

    @Column
    @Basic
    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
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
    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    @Column
    @Basic
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
