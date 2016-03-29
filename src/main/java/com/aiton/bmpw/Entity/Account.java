package com.aiton.bmpw.entity;

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
    private String login_id;
    private String idCard; //身份证号
    private Integer cardStatus;//证件类型:0:居民身份证,1:士兵证,2:军官证,3:警官证,4:护照,5:其它
    private String bankCard;   //银行卡号
    private String phone;
    private String address;
    private String image;
    private String note; //备注
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(Integer cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", login_id='" + login_id + '\'' +
                ", idCard='" + idCard + '\'' +
                ", cardStatus=" + cardStatus +
                ", bankCard='" + bankCard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
