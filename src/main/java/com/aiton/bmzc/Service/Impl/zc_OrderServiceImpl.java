package com.aiton.bmzc.Service.Impl;
import com.aiton.bmzc.Dao.zc_CarRespository;
import com.aiton.bmzc.Dao.zc_OrderRepository;
import com.aiton.bmzc.Dao.zc_PlanRepository;
import com.aiton.bmzc.Entity.zc_Car;
import com.aiton.bmzc.Entity.zc_Order;
import com.aiton.bmzc.Entity.zc_plan;
import com.aiton.bmzc.Service.zc_OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午4:24
 * To change this template use File | Settings | File Templates.
 */
@Service
public class zc_OrderServiceImpl implements zc_OrderService {
    @Resource
    private zc_OrderRepository orderRepository;
    @Resource
    private zc_PlanRepository planRepository;
    @Resource
    private zc_CarRespository carRespository;
    @Override
    public zc_Order addOrder(zc_Order order) {
        zc_Car car=carRespository.findOne(order.getLicensePlate());
        order.setPlanId(car.getPlanId());
        zc_plan plan=planRepository.findOne(car.getPlanId());
        if(plan.getUnit()==0){//日租
            //计价时间（天）
            Long time=order.getPlanReturnDate().getTime()-order.getZuchuDate().getTime();
            order.setJijiatime((int)StrictMath.ceil(time/86400000));//计价时间按天数显示
        }
        if(plan.getUnit()==1){//月租
            //计价时间(月)
            Calendar c1=Calendar.getInstance();
            Calendar c2=Calendar.getInstance();
            c1.setTime(order.getPlanReturnDate());
            c2.setTime(order.getZuchuDate());
            int result=c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH);
            order.setJijiatime(result==0?1:StrictMath.abs(result));//计价时间按月份显示
        }
        order.setLimitMileage(plan.getUnitMileage()*order.getJijiatime());
        order.setFlag(0);//订单进行中
        order=orderRepository.saveAndFlush(order);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }
    //取消订单
    @Override
    public Boolean cancelOrder(Integer order_id) {
        zc_Order order=orderRepository.findOne(order_id);
        if(order==null){
           return false;
        }
        order.setFlag(2);//订单取消
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public zc_Order addDriver(Integer order_id,Integer driver_id) {
        zc_Order order=orderRepository.findOne(order_id);
        order.setDriverId(driver_id);
        orderRepository.saveAndFlush(order);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public zc_Order loadOrder(Integer order_id, Timestamp huancheDate, Double afterMileage, Double shouyajin) {
        zc_Order order=orderRepository.findOne(order_id);
        if(order==null){
           return null;
        }
        zc_Car car=carRespository.findOne(order.getLicensePlate());
        car.setStatus(0);
        order.setAfterMileage(afterMileage);
        order.setShouyajin(shouyajin);
        order.setHuancheDate(huancheDate);
        zc_plan plan=planRepository.findOne(order.getPlanId());
        //计时应收租金&计价时间
        if(plan.getUnit()==0){//日租
           //计价时间（天）
            Long time=huancheDate.getTime()-order.getZuchuDate().getTime();
            order.setJijiatime((int)StrictMath.ceil(time/86400000));//计价时间按天数显示
            //计时应收租金
            Long t=order.getPlanReturnDate().getTime()-order.getZuchuDate().getTime();
            order.setTimePrice(StrictMath.ceil(t/86400000)*plan.getPrice());
        }
        if(plan.getUnit()==1){//月租
           //计价时间(月)
            Calendar c1=Calendar.getInstance();
            Calendar c2=Calendar.getInstance();
            c1.setTime(huancheDate);
            c2.setTime(order.getZuchuDate());
            int result=c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH);
            order.setJijiatime(result==0?1:StrictMath.abs(result));//计价时间按月份显示
            //计时应收租金
            Calendar c3=Calendar.getInstance();
            c3.setTime(order.getPlanReturnDate());
            int m=c3.get(Calendar.MONTH)-c2.get(Calendar.MONTH);
            int mouth=m==0?1:StrictMath.abs(m);
            order.setTimePrice(mouth*plan.getPrice());
        }
        //限制里程数
        order.setLimitMileage(plan.getUnitMileage()*order.getJijiatime());
        //超里程数
        double m=afterMileage-order.getBeforeMileage();
        //超里程价格
        order.setOutMileagePrice(m*plan.getOutMileage());
        //超时价格
        //超时时间
        if(huancheDate.getTime()>order.getPlanReturnDate().getTime()){//超时
            Long time=huancheDate.getTime()-order.getPlanReturnDate().getTime();
            Integer hour=((int)StrictMath.ceil(time/3600000));//超时小时数
            order.setOutTimePrice(hour*plan.getOutTime());
        }
        orderRepository.saveAndFlush(order);
        //汽车置空闲


        carRespository.saveAndFlush(car);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public zc_Order completeOrder(Integer order_id, Double price,Double shouyajin) {
        zc_Order order=orderRepository.findOne(order_id);
        if(order==null){
            return null;
        }
        order.setPrice(price);
        order.setShouyajin(shouyajin);
        order.setFlag(1);//订单完成
        orderRepository.saveAndFlush(order);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<zc_Order> loadorderByaccount(Integer accountId) {
        List<zc_Order>orders=orderRepository.findOrderByAccountId(accountId);
        return orders;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<zc_Order> loadCanCompleteOrder() {
        List<zc_Order>orders=orderRepository.findIngOrder();
        return orders;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
