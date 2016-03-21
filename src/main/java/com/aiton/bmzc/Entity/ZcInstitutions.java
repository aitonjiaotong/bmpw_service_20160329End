package com.aiton.bmzc.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 下午2:52
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;

/**
 * 机构
 */
@Entity
@Table
public class ZcInstitutions {
    private String name;//机构名称
    private String head;//机构联系人
    private String phone;//机构电话
    private String code;//机构编号
    private String password;

    @Id
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Basic
    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Basic
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
    @Basic
    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
