package com.aiton.bmdc.entity.global;

import java.util.Date;

/**
 * 八闽钱包类型：ID,用户ID，余额，充值总额
 *          消费总额，上一次充值时间，
 *          账号状态（开通/冻结/注销）
 * Created by user on 2016/3/17.
 */
public class BMWallet{
    private Integer id;
    /**用户ID*/
    private Integer account_id;
    /**余额*/
    private Double balance;
    /**历史充值总额*/
    private Double total_recharge;
    /**历史消费总额*/
    private Double total_spend;
    /**最近一次充值的时间*/
    private Date last_recharge_date;
    /**钱包的状态（0开通；1冻结；2注销）*/
    private Integer status;
 //   /**绑定的银行卡卡号*/
 //   private String card_id;
 //   /**绑定的银行卡发卡银行*/
 //   private String card_bank;
}
