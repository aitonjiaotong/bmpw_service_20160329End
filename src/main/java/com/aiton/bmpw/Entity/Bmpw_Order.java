package com.aiton.bmpw.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-16
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class Bmpw_Order {
    private Integer id;
//    private String start;
//    private String end;
//    private Integer person_id;
//    private Double price;
    private Timestamp date;//下订单时间
//    private Integer state;
//    private Integer carrychild;
//    private Integer insured;
    private String bookLogAID;
//    private String getTicketCode;
//    private String logID;
    private Integer account_id;
    private Integer redEnvelope_id;
    private String phone;
//    private Integer flag;//订单标记位 0：未确认 1：已确认 2：已撤销 3：已取票
//    @Basic
//    @Column
//    public Integer getFlag() {
//        return flag;
//    }
//
//    public void setFlag(Integer flag) {
//        this.flag = flag;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
//    @Basic
//    @Column
//    public String getStart() {
//        return start;
//    }
//
//    public void setStart(String start) {
//        this.start = start;
//    }
//    @Basic
//    @Column
//    public String getEnd() {
//        return end;
//    }
//
//    public void setEnd(String end) {
//        this.end = end;
//    }
//    @Basic
//    @Column
//    public Integer getPerson_id() {
//        return person_id;
//    }
//
//    public void setPerson_id(Integer person_id) {
//        this.person_id = person_id;
//    }
//    @Basic
//    @Column
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
    @Column
    @Basic
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
//    @Basic
//    @Column
//    public Integer getState() {
//        return state;
//    }
//
//    public void setState(Integer state) {
//        this.state = state;
//    }
//    @Basic
//    @Column
//    public Integer getCarrychild() {
//        return carrychild;
//    }
//
//    public void setCarrychild(Integer carrychild) {
//        this.carrychild = carrychild;
//    }
//    @Basic
//    @Column
//    public Integer getInsured() {
//        return insured;
//    }
//
//    public void setInsured(Integer insured) {
//        this.insured = insured;
//    }
    @Basic
    @Column
    public String getBookLogAID() {
        return bookLogAID;
    }

    public void setBookLogAID(String bookLogAID) {
        this.bookLogAID = bookLogAID;
    }

//    public String getGetTicketCode() {
//        return getTicketCode;
//    }
//
//    public void setGetTicketCode(String getTicketCode) {
//        this.getTicketCode = getTicketCode;
//    }
//
//    public String getLogID() {
//        return logID;
//    }
//
//    public void setLogID(String logID) {
//        this.logID = logID;
//    }
    @Basic
    @Column
    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }
    @Column
    @Basic
    public Integer getRedEnvelope_id() {
        return redEnvelope_id;
    }

    public void setRedEnvelope_id(Integer redEnvelope_id) {
        this.redEnvelope_id = redEnvelope_id;
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
