package com.aiton.bmpw.Entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Account: Administrator
 * Date: 16-2-4
 * Time: 上午8:54
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class Account {
    //用户表
    private Integer id;
    private String name;
    private String password;
    private Integer sex;//0：女 1：男
    private String image;
    private String phone;
    private String login_id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Basic
    @Column(unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    @Basic
    @Column
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Basic(optional = false)
    @Column(unique = true,nullable =false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }
}
