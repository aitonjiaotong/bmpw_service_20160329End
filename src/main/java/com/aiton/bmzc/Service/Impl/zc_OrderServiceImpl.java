package com.aiton.bmzc.Service.Impl;
import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Dao.zc_CarRespository;
import com.aiton.bmzc.Dao.zc_OrderRepository;
import com.aiton.bmzc.Dao.zc_PlanRepository;
import com.aiton.bmzc.Entity.*;
import com.aiton.bmzc.Service.zc_OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public zc_Order addOrder(zc_order_request order_request) {
        zc_Order order=new zc_Order();
        zc_car_plan car_plan=order_request.getCar_plan();
        order.setPlanId(car_plan.getPlan_id());
        order.setGetCar(order_request.getGetCar());
        order.setReturnCar(order_request.getReturnCar());
        order.setZuchuDate(order_request.getZuchuDate());
        order.setPlanReturnDate(order_request.getPlanReturnDate());
        order.setPrice(order_request.getPrice());
        order.setInsurance(order_request.getInsurance());
        List<zc_Car>cars=carRespository.find(car_plan.getModel(),car_plan.getType(),car_plan.getBox(),car_plan.getPailiang(),car_plan.getSeat(),car_plan.getPlan_id());
        if(cars.isEmpty()){
           return null;
        }
        zc_Car car=cars.get(0);
        car.setStatus(1);//车辆被租出
        order.setLicensePlate(car.getLicensePlate());
//        zc_plan plan=planRepository.findOne(order.getPlanId());
//        Long time=order.getPlanReturnDate().getTime()-order.getZuchuDate().getTime();
//        order.setJijiatime((int)StrictMath.ceil(time/86400000));//计价时间按天数显示
//        order.setLimitMileage(plan.getUnitMileage()*order.getJijiatime());
        order.setFlag(0);//订单进行中
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order=orderRepository.saveAndFlush(order);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }
    //取消订单
    @Override
    public Boolean cancelOrder(Integer order_id) {
        try{
            zc_Order order=orderRepository.findOne(order_id);
            if(order==null){
                return false;
            }
            order.setFlag(2);//订单取消
            return true;
        }catch (Exception e){
            return false;
        }
          //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public zc_Order addDriver(Integer order_id,Integer driver_id) {
        try{
            zc_Order order=orderRepository.findOne(order_id);
            order.setDriverId(driver_id);
            orderRepository.saveAndFlush(order);
            return order;
        }catch(Exception e){
            return null;
        }
         //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 还车时加载订单
     * @param order_id
     * @param huancheDate
     * @param afterMileage
     * @param shouyajin
     * @return
     */
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
        //计价时间（天）
        Long time=huancheDate.getTime()-order.getZuchuDate().getTime();
        order.setJijiatime((int)StrictMath.ceil(time/86400000));//计价时间按天数显示
        //计时应收租金
        Long t=order.getPlanReturnDate().getTime()-order.getZuchuDate().getTime();
        order.setTimePrice(StrictMath.ceil(t/86400000)*plan.getPrice());
        //限制里程数
        order.setLimitMileage(plan.getUnitMileage()*order.getJijiatime());
        //超里程数
        double m=afterMileage-order.getBeforeMileage();
        //超里程价格
        if(m>order.getLimitMileage()){
            order.setOutMileagePrice((m-order.getLimitMileage())*plan.getOutMileage());
        }
        //超时价格
        //超时时间
        if(huancheDate.getTime()>order.getPlanReturnDate().getTime()){//超时
            time=huancheDate.getTime()-order.getPlanReturnDate().getTime();
            Integer hour=((int)StrictMath.ceil(time/3600000));//超时小时数
            order.setOutTimePrice(hour*plan.getOutTime());
        }
        orderRepository.saveAndFlush(order);
        //汽车置空闲
        carRespository.saveAndFlush(car);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public zc_Order completeOrder(Integer order_id, Double price,Double shouyajin,String note,String sale) {
        zc_Order order=orderRepository.findOne(order_id);
        if(order==null){
            return null;
        }
        order.setSale(sale);
        order.setNote(note);
        order.setPrice(price);
        order.setShouyajin(shouyajin);
        order.setFlag(1);//订单完成
        orderRepository.saveAndFlush(order);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<zc_Order> loadorderByaccount(Integer accountId,Integer page) {
        List<zc_Order>orders=orderRepository.findOrderByAccountId(accountId,new PageRequest(page,8,new Sort(Sort.Direction.DESC,"date"))).getContent();
        return orders;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 加载正在进行的订单
     * @return
     */
    @Override
    public DataTables loadCanCompleteOrder(Integer draw,Integer start,Integer length) {
        Integer page=start/length;
        List<zc_Order>orders=orderRepository.findIngOrder(new PageRequest(page,length,new Sort(Sort.Direction.ASC,"planReturnDate"))).getContent();
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);

        dataTables.setRecordsTotal(Long.valueOf(orderRepository.CountIngOrder().toString()));
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
