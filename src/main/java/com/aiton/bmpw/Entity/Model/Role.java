package com.aiton.bmpw.entity.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午11:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class Role {
    private Integer role_id;
    private String role_name;
    private String role_descript;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
    @Basic
    @Column
    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
    @Column
    @Basic
    public String getRole_descript() {
        return role_descript;
    }

    public void setRole_descript(String role_descript) {
        this.role_descript = role_descript;
    }
}
