package com.aiton.bmpw.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-16
 * Time: 下午4:50
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
/**
 * 意见反馈
 */
public class FeedBack {
    private Integer id;
    private Integer account_id;
    private String content;
    private Timestamp date;
    private String phone;
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
    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer user_id) {
        this.account_id = user_id;
    }
    @Basic
    @Column
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Basic
    @Column
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
