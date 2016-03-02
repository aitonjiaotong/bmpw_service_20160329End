package com.aiton.bmgj.entity;



import javax.persistence.*;

/**
 * 乘客类型：ID,姓名，密码，公交卡ID；
 * Created by user on 2016/3/2.
 */
@Entity
@Table
public class User {

    private Integer userId;
    private String userName;
    private String password;
    /**公交卡的id*/
    private Integer busCardId;

    @Id
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Column
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column
    @Basic
    public Integer getBusCardId() {
        return busCardId;
    }

    public void setBusCardId(Integer busCardId) {
        this.busCardId = busCardId;
    }
}
