package com.aiton.bmdc.entity;

import javax.persistence.*;

/**
 * 打车模块司机类：ID,姓名，手机号码，
 *      位置经度，位置纬度，支付宝账号
 * Created by user on 2016/3/17.
 */
@Entity
@Table
public class DCDriver {
    private Integer driver_id;
    /**司机的真实姓名*/
    private String driver_name;
    /**司机电话*/
    private String phone;
    /**经度*/
    private Double latitude;
    /**纬度*/
    private Double longitude;
    /**支付宝账号*/
    private String alipay;
    /**身份证号码*/
    private String idCard_no;
    /**身份证照片*/
    private String idCard_image;
    /**驾驶证照片*/
    private String license_image;
    /**车辆行驶证照片*/
    private String drivingLicense_image;
    /**车牌号*/
    private String car_no;
    /**车牌照片*/
    private String car_no_image;

    @Id
    @Column
    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }

    @Column
    @Basic
    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    @Column
    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column
    @Basic
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Column
    @Basic
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Column
    @Basic
    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    @Column
    @Basic
    public String getIdCard_no() {
        return idCard_no;
    }

    public void setIdCard_no(String idCard_no) {
        this.idCard_no = idCard_no;
    }

    @Column
    @Basic
    public String getIdCard_image() {
        return idCard_image;
    }

    public void setIdCard_image(String idCard_image) {
        this.idCard_image = idCard_image;
    }

    @Column
    @Basic
    public String getLicense_image() {
        return license_image;
    }

    public void setLicense_image(String license_image) {
        this.license_image = license_image;
    }

    @Column
    @Basic
    public String getDrivingLicense_image() {
        return drivingLicense_image;
    }

    public void setDrivingLicense_image(String drivingLicense_image) {
        this.drivingLicense_image = drivingLicense_image;
    }

    @Column
    @Basic
    public String getCar_no() {
        return car_no;
    }

    public void setCar_no(String car_no) {
        this.car_no = car_no;
    }

    @Column
    @Basic
    public String getCar_no_image() {
        return car_no_image;
    }

    public void setCar_no_image(String car_no_image) {
        this.car_no_image = car_no_image;
    }
}
