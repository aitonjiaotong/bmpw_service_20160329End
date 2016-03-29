package com.aiton.bmpw.entity.show;

import com.aiton.bmpw.entity.Bmpw_Order;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-10
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
public class pw_Order_show {
    private List<Bmpw_Order> orders;
    private Integer pages;

    public List<Bmpw_Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Bmpw_Order> orders) {
        this.orders = orders;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
