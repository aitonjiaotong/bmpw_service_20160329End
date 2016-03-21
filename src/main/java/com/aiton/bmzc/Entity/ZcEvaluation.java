package com.aiton.bmzc.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 上午11:38
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;

/**
 * 司机评价表
 */
@Entity
@Table
public class ZcEvaluation {
    private Integer id;
    private Integer driverId;
    private String contains;
    private Integer star;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
    @Basic
    @Column
    public String getContains() {
        return contains;
    }

    public void setContains(String contains) {
        this.contains = contains;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
