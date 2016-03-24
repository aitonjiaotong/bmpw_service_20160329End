package com.aiton.bmzc.Service;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Entity.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 */
public interface ZcOrderService {
    ZcOrder addDriver(Integer order_id,Integer driver_id);
    ZcOrder addOrder1(ZcOrderRequest order_request);
    Boolean cancelOrder(Integer order_id);
    ZcOrder loadOrder(Integer order_id,Timestamp huancheDate,Double afterMileage,Double shouyajin);
    ZcOrder completeOrder(Integer order_id,Double price,Double shouyajin,String note,String sale);
    ZcContainsNum loadorderByaccount(Integer accountId,Integer page);
    DataTables loadCanCompleteOrder(Integer draw,Integer start,Integer length,HttpServletRequest request);
    ZcOrder addOrder2(ZcOrderRequest order_request);
    ZcCarAndPlan beforeOrder(Integer lei);
    ZcOrder addOrderFromPage(ZcOrder zcOrder);
}
