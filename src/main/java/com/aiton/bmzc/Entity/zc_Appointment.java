package com.aiton.bmzc.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-16
 * Time: 下午1:53
 * To change this template use File | Settings | File Templates.
 */
/*
预约表
 */
@Entity
@Table
public class zc_Appointment {
    private Integer id;
    private String user;//预约人（预约电话）
    private Timestamp planzuche;//预约租车时间
    private String note;//预约事项
    private Timestamp appointmenttime;//预约时间
    private Integer flag;//预约状态 0：等待派车 1：已派车 2：取消
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
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    @Basic
    @Column
    public Timestamp getPlanzuche() {
        return planzuche;
    }

    public void setPlanzuche(Timestamp planzuche) {
        this.planzuche = planzuche;
    }
    @Basic
    @Column
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    @Basic
    @Column
    public Timestamp getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(Timestamp appointmenttime) {
        this.appointmenttime = appointmenttime;
    }
    @Basic
    @Column
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
