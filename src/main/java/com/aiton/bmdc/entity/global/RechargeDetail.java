package com.aiton.bmdc.entity.global;

import java.util.Date;

/**
 * 充值明细类:ID,充值金额，赠送金额
 *           充入账号，充值时间，充值用户ID
 * Created by user on 2016/3/17.
 */
public class RechargeDetail {
    /**ID*/
    private Integer id;
    /**充值金额*/
    private Double recharge;
    /**赠送金额*/
    private Double reward;
    /**充入账号*/
    private Integer wallet_id;
    /**充值时间*/
    private Date recharge_date;
    /**充值用户的ID*/
    private Integer user_id;
}
