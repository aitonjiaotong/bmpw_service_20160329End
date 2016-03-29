package com.aiton.bmzc.Entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午2:37
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table
public class ZcPlan {
    private Integer id;
    private String name;//方案名称
    private Double price;//单价
    private Double unitMileage;//单位里程数
    private Double outMileage;//超里程价格
    private Double outTime;//超时小时价
    private Integer flag;//0：可用 1：删除
    private Integer jijia;//计价方式 0：天 1：小时 2：月（默认天）
    private Double insurance;//保险
    private Double hasDriver;//带司机
    private Double others;//其他费用
    private Double poundage;//手续费
    private Double franchiseFees;//不计免赔服务费

    @Column
    @Basic
    public Double getOthers() {
        return others;
    }

    public void setOthers(Double others) {
        this.others = others;
    }
    @Column
    @Basic
    public Double getPoundage() {
        return poundage;
    }

    public void setPoundage(Double poundage) {
        this.poundage = poundage;
    }
    @Basic
    @Column
    public Double getFranchiseFees() {
        return franchiseFees;
    }

    public void setFranchiseFees(Double franchiseFees) {
        this.franchiseFees = franchiseFees;
    }

    @Basic
    @Column
    public Integer getJijia() {
        return jijia;
    }

    public void setJijia(Integer jijia) {
        this.jijia = jijia;
    }
    @Basic
    @Column
    public Double getHasDriver() {
        return hasDriver;
    }

    public void setHasDriver(Double hasDriver) {
        this.hasDriver = hasDriver;
    }

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
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @Basic
    @Column
    public Double getUnitMileage() {
        return unitMileage;
    }

    public void setUnitMileage(Double unitMileage) {
        this.unitMileage = unitMileage;
    }
    @Basic
    @Column
    public Double getOutMileage() {
        return outMileage;
    }

    public void setOutMileage(Double outMileage) {
        this.outMileage = outMileage;
    }
    @Column
    @Basic
    public Double getOutTime() {
        return outTime;
    }

    public void setOutTime(Double outTime) {
        this.outTime = outTime;
    }
    @Basic
    @Column
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
    @Column
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "ZcPlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unitMileage=" + unitMileage +
                ", outMileage=" + outMileage +
                ", outTime=" + outTime +
                ", flag=" + flag +
                ", jijia=" + jijia +
                '}';
    }
}
