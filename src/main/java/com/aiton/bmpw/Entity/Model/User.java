package com.aiton.bmpw.entity.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class User {
    private Integer id;
    private String user_password;
    private String user_code;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer user_id) {
        this.id = user_id;
    }
    @Column(nullable = false)
    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
    @Column(unique = true)
    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }
}
