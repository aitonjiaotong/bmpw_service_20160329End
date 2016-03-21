package com.aiton.bmzc.Service.Impl;
import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Dao.ZcCarRespository;
import com.aiton.bmzc.Dao.ZcOrderRepository;
import com.aiton.bmzc.Dao.ZcPlanRepository;
import com.aiton.bmzc.Entity.*;
import com.aiton.bmzc.Service.ZcOrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午4:24
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ZcOrderServiceImpl implements ZcOrderService {
    @Resource
    private ZcOrderRepository orderRepository;
    @Resource
    private ZcPlanRepository planRepository;
    @Resource
    private ZcCarRespository carRespository;

    @Override
    public ZcOrder addOrder(ZcOrderRequest order_request) {
        ZcOrder order=new ZcOrder();
        order.setPlanId(order_request.getPlan_id());
        order.setGetCar(order_request.getGetCar());
        order.setReturnCar(order_request.getReturnCar());
        order.setZuchuDate(order_request.getZuchuDate());
        order.setPlanReturnDate(order_request.getPlanReturnDate());
        order.setPrice(order_request.getPrice());
        order.setInsurance(order_request.getInsurance());
        order.setHasDriver(order_request.getHasDriver());
        List<ZcCar>cars=carRespository.find(order_request.getModel(), order_request.getType(), order_request.getBox(), order_request.getPailiang(), order_request.getSeat(), order_request.getPlan_id());
        if(cars.isEmpty()){
           return null;
        }
        ZcCar car=cars.get(0);
        car.setStatus(1);//车辆被租出
        order.setLicensePlate(car.getLicensePlate());
        order.setFlag(0);//订单进行中
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order=orderRepository.saveAndFlush(order);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }
    //取消订单
    @Override
    public Boolean cancelOrder(Integer order_id) {
        try{
            ZcOrder order=orderRepository.findOne(order_id);
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
    public ZcOrder addDriver(Integer order_id,Integer driver_id) {
        try{
            ZcOrder order=orderRepository.findOne(order_id);
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
    public ZcOrder loadOrder(Integer order_id, Timestamp huancheDate, Double afterMileage, Double shouyajin) {
        ZcOrder order=orderRepository.findOne(order_id);
        if(order==null){
           return null;
        }
        ZcCar car=carRespository.findOne(order.getLicensePlate());
        car.setStatus(0);
        order.setAfterMileage(afterMileage);
        order.setShouyajin(shouyajin);
        order.setHuancheDate(huancheDate);
        ZcPlan plan=planRepository.findOne(order.getPlanId());
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
    public ZcOrder completeOrder(Integer order_id, Double price,Double shouyajin,String note,String sale) {
        ZcOrder order=orderRepository.findOne(order_id);
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
    public ZcContainsNum loadorderByaccount(Integer accountId,Integer page) {
        List<ZcOrder>orders=orderRepository.findOrderByAccountId(accountId,new PageRequest(page,8,new Sort(Sort.Direction.DESC,"date"))).getContent();
        ZcContainsNum contains_num=new ZcContainsNum();
        contains_num.setContains(orders);
        Integer pageAll=(int)Math.ceil(Double.valueOf(orderRepository.countOrderByAccountId(accountId).toString())/8);
        contains_num.setNum(pageAll);
        return contains_num;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 加载正在进行的订单
     * @return
     */
    @Override
    public DataTables loadCanCompleteOrder(Integer draw,Integer start,Integer length,String search) {
        Integer page=start/length;
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        dataTables.setRecordsTotal(Long.valueOf(orderRepository.CountIngOrder().toString()));
        List<ZcOrder>orders=new ArrayList<ZcOrder>();
        if("".equals(search)||search==null){
            dataTables.setRecordsFiltered(orderRepository.count());
            orders=orderRepository.findIngOrder(new PageRequest(page,length,new Sort(Sort.Direction.ASC,"planReturnDate"))).getContent();
        }else{
            search="%"+search+"%";
        }
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
