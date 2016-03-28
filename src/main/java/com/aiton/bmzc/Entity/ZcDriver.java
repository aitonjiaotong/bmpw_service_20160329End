package com.aiton.bmzc.Entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午2:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class ZcDriver {
    private Integer id;
    private String name;
    private String phone;
    private String idcard;
    private String sex;
    private Integer drivingYear;
    private String image;
    private Double star;
    private Integer status;//0：出车 1：空闲

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Basic
    @Column
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    @Basic
    @Column
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @Basic
    @Column
    public Integer getDrivingYear() {
        return drivingYear;
    }

    public void setDrivingYear(Integer drivingYear) {
        this.drivingYear = drivingYear;
    }
    @Basic
    @Column
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Basic
    @Column
    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }

    @Basic
    @Column
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ZcDriver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", idcard='" + idcard + '\'' +
                ", sex='" + sex + '\'' +
                ", drivingYear=" + drivingYear +
                ", image='" + image + '\'' +
                ", star=" + star +
                ", status=" + status +
                '}';
    }
}
