package com.aiton.bmzc.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 下午5:53
 * To change this template use File | Settings | File Templates.
 */
public class ZcCarPlan {
    private String model;//品牌
    private String type;//型号
    private String box;//厢数
    private String pailiang;//排量
    private Integer seat;//乘客数量
    private Integer zidong;//0:自动 1:手动
    private Integer plan_id;
    private String image;
    private ZcPlan plan;
    public ZcCarPlan(String model, String type, String box, String pailiang, Integer seat, Integer zidong, Integer plan_id, String image) {
        this.model = model;
        this.type = type;
        this.box = box;
        this.pailiang = pailiang;
        this.seat = seat;
        this.zidong = zidong;
        this.plan_id = plan_id;
        this.image = image;
    }

    public ZcPlan getPlan() {
        return plan;
    }

    public void setPlan(ZcPlan plan) {
        this.plan = plan;
    }

    public ZcCarPlan() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getPailiang() {
        return pailiang;
    }

    public void setPailiang(String pailiang) {
        this.pailiang = pailiang;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getZidong() {
        return zidong;
    }

    public void setZidong(Integer zidong) {
        this.zidong = zidong;
    }

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
