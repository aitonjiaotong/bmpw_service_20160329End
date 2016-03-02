package com.aiton.bmpw.Entity.Show;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 下午12:27
 * To change this template use File | Settings | File Templates.
 */
public class Order_show {
    private String GetTicketCode;
    private String StartSiteName;
    private String EndSiteName;
    private Timestamp date;
    private String MyStateDesc;
    private Boolean CarryChild;
    private Double Price;
    private Double amount;
    private String PhoneNumber;

    public String getGetTicketCode() {
        return GetTicketCode;
    }

    public void setGetTicketCode(String getTicketCode) {
        GetTicketCode = getTicketCode;
    }

    public String getStartSiteName() {
        return StartSiteName;
    }

    public void setStartSiteName(String startSiteName) {
        StartSiteName = startSiteName;
    }

    public String getEndSiteName() {
        return EndSiteName;
    }

    public void setEndSiteName(String endSiteName) {
        EndSiteName = endSiteName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date=date;
    }

    public String getMyStateDesc() {
        return MyStateDesc;
    }

    public void setMyStateDesc(String myStateDesc) {
        MyStateDesc = myStateDesc;
    }

    public Boolean getCarryChild() {
        return CarryChild;
    }

    public void setCarryChild(Boolean carryChild) {
        CarryChild = carryChild;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
