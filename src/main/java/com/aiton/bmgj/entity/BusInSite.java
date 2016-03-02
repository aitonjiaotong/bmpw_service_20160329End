package com.aiton.bmgj.entity;

import javax.persistence.*;

/**
 * 站点公交：ID，站点ID,公交ID,顺序；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class BusInSite {
    private Integer id;
    private Integer busId;
    private Integer siteId;
    private Integer row;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    @Column
    @Basic
    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}
