package com.aiton.bmzc.entity;



/**
 * Created by user on 2016/3/26.
 */
public class ZcAppointmentGetFromPage {
    private Integer id;
    private String user;//预约人（预约电话）
    private String planzuche;//预约租车时间
    private String note;//预约事项
    private String appointmenttime;//预约时间
    private Integer flag;//预约状态 0：等待派车 1：已派车 2：取消

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPlanzuche() {
        return planzuche;
    }

    public void setPlanzuche(String planzuche) {
        this.planzuche = planzuche;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(String appointmenttime) {
        this.appointmenttime = appointmenttime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ZcAppointmentGetFromPage{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", planzuche='" + planzuche + '\'' +
                ", note='" + note + '\'' +
                ", appointmenttime='" + appointmenttime + '\'' +
                ", flag=" + flag +
                '}';
    }
}
