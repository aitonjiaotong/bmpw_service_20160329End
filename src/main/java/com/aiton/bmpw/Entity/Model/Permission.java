package com.aiton.bmpw.entity.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午11:47
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class Permission {
    private Integer permission_id;
    private String url;
    private String descript;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }
    @Basic
    @Column
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Basic
    @Column
    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
