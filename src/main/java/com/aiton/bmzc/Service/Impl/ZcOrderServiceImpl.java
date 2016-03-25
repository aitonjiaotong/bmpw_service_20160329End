package com.aiton.bmzc.Service.Impl;

import com.aiton.bmpw.Dao.AccountReponstory;
import com.aiton.bmpw.Entity.Account;
import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Dao.ZcCarRespository;
import com.aiton.bmzc.Dao.ZcDriverRepository;
import com.aiton.bmzc.Dao.ZcOrderRepository;
import com.aiton.bmzc.Dao.ZcPlanRepository;
import com.aiton.bmzc.Entity.*;
import com.aiton.bmzc.Service.ZcOrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    @Resource(name = "zcDriverRepository")
    private ZcDriverRepository driverRepository;
    @Resource
    private AccountReponstory accountReponstory;
    //机构租车添加订单
    @Override
    public ZcOrder addOrder1(ZcOrderRequest order_request) {
        ZcOrder order=new ZcOrder();
        order.setStatus(0);
        order.setInstitutionsCode(order_request.getInstitutionsCode());
        order.setPlanId(order_request.getPlan_id());
        order.setGetCar(order_request.getGetCar());
        order.setReturnCar(order_request.getReturnCar());
        order.setZuchuDate(order_request.getZuchuDate());
        order.setPlanReturnDate(order_request.getPlanReturnDate());
        order.setPrice(order_request.getPrice());
        order.setInsurance(order_request.getInsurance());
        order.setHasDriver(order_request.getHasDriver());
        ZcCar car=carRespository.findOne(order_request.getCarId());
        order.setBeforeMileage(car.getMileage());
        car.setStatus(1);//车辆被租出
        order.setCarId(car.getId());
        order.setFlag(0);//订单进行中
        order.setDate(new Timestamp(System.currentTimeMillis()));
        if(order_request.getHasDriver().equals(0)){
            ZcOrder order1=orderRepository.checkDriver(order.getDriverId());
            if(order1!=null){
                return null;
            }else{
                ZcDriver driver=driverRepository.findOne(order.getDriverId());
                driver.setStatus(0);
                driverRepository.saveAndFlush(driver);
            }
        }
        order=orderRepository.saveAndFlush(order);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }
    //个人租车添加订单
    @Override
    public ZcOrder addOrder2(ZcOrderRequest order_request) {
        ZcOrder order=new ZcOrder();
        order.setStatus(1);
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
        Random ran=new Random();
        int s = ran.nextInt(cars.size());
        ZcCar car=cars.get(s);
        order.setBeforeMileage(car.getMileage());
        car.setStatus(1);//车辆被租出
        order.setCarId(car.getId());
        order.setFlag(0);//订单进行中
        if(order_request.getHasDriver().equals(0)){
           ZcOrder order1=orderRepository.checkDriver(order.getDriverId());
            if(order1!=null){
               return null;
            }else{
                ZcDriver driver=driverRepository.findOne(order.getDriverId());
                driver.setStatus(0);
                driverRepository.saveAndFlush(driver);
            }
        }
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
            if(order.getHasDriver().equals(0)){
                ZcDriver driver=driverRepository.findOne(order.getDriverId());
                driver.setStatus(1);
                driverRepository.saveAndFlush(driver);
            }
            orderRepository.saveAndFlush(order);
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
     * @return
     */
    @Override
    public ZcOrder loadOrder(Integer order_id, Timestamp huancheDate, Double afterMileage) {
        ZcOrder order=orderRepository.findOne(order_id);
        if(order==null){
           return null;
        }
        Double shouyajin = order.getShouyajin();
        ZcCar car=carRespository.findOne(order.getCarId());
        car.setStatus(0);
        car.setStore_id(order.getReturnCar());
        order.setAfterMileage(afterMileage);
        order.setShouyajin(shouyajin);
        order.setHuancheDate(huancheDate);
        ZcPlan plan=planRepository.findOne(order.getPlanId());
        //计时应收租金&计价时间
        //计价时间（天）
        Long time=order.getPlanReturnDate().getTime()-order.getZuchuDate().getTime();
        order.setJijiatime((int)StrictMath.ceil(time/86400000));//计价时间按天数显示
        //计时应收租金
        order.setTimePrice(order.getJijiatime()*plan.getPrice());
        //总共使用的里程数
        double m=afterMileage-order.getBeforeMileage();
        if(m>order.getLimitMileage()){
            order.setOutMileagePrice((m-order.getLimitMileage())*plan.getOutMileage());
        }
        //超时价格
        //超时时间
        if(huancheDate.getTime()>order.getPlanReturnDate().getTime()){
            //超时
            time=huancheDate.getTime()-order.getPlanReturnDate().getTime();
            Integer hour=((int)StrictMath.ceil(time/3600000));//超时小时数
            order.setOutTimePrice(hour*plan.getOutTime());
        }
        order.setFlag(3);
        if(order.getHasDriver().equals(0)){
            ZcDriver driver=driverRepository.findOne(order.getDriverId());
            driver.setStatus(1);
            driverRepository.saveAndFlush(driver);
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
        List<ZcOrderCar>list=new ArrayList<ZcOrderCar>();
        for(ZcOrder order:orders){
            ZcOrderCar orderCar=new ZcOrderCar();
            orderCar.setOrder(order);
            orderCar.setCar(carRespository.findOne(order.getCarId()));
            list.add(orderCar);
        }
        contains_num.setContains(list);
        Integer pageAll=(int)Math.ceil(Double.valueOf(orderRepository.countOrderByAccountId(accountId).toString())/8);
        contains_num.setNum(pageAll);
        return contains_num;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 加载正在进行的订单，未还车
     * @return
     */
    @Override
    public DataTables loadCanCompleteOrder(Integer draw,Integer start,Integer length,HttpServletRequest request) {
        String search=request.getParameter("search[value]");
        Integer page=start/length;
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        Object l=orderRepository.CountIngOrder();
        List<ZcCarPlanOrderAccount> list=new ArrayList<ZcCarPlanOrderAccount>();
        if(l==null){
            dataTables.setRecordsTotal(0l);
            dataTables.setRecordsFiltered(0l);
            dataTables.setData(list);
            return dataTables;
        }
        dataTables.setRecordsTotal(Long.valueOf(l.toString()));
        List<ZcOrder>orders=new ArrayList<ZcOrder>();
        if("".equals(search)||search==null){
            dataTables.setRecordsFiltered(Long.valueOf(l.toString()));
            orders=orderRepository.findIngOrder(new PageRequest(page,length,new Sort(Sort.Direction.ASC,"planReturnDate"))).getContent();
            for(ZcOrder order:orders){
                ZcPlan plan=planRepository.findOne(order.getPlanId());
                ZcCar car=carRespository.findOne(order.getCarId());
                Account account=accountReponstory.findOne(order.getAccountId());
                ZcCarPlanOrderAccount carPlanOrderAccount=new ZcCarPlanOrderAccount(car,plan,order,account);
                list.add(carPlanOrderAccount);
            }
            dataTables.setData(list);
        }else{
            search="%"+search+"%";
            List<Object>accounts=accountReponstory.findByPhoneLike(search);
            orders=orderRepository.findIngOrderByAccount(accounts,new PageRequest(page,length,new Sort(Sort.Direction.ASC,"planReturnDate"))).getContent();
            for(ZcOrder order:orders){
                ZcPlan plan=planRepository.findOne(order.getPlanId());
                ZcCar car=carRespository.findOne(order.getCarId());
                Account account=accountReponstory.findOne(order.getAccountId());
                ZcCarPlanOrderAccount carPlanOrderAccount=new ZcCarPlanOrderAccount(car,plan,order,account);
                list.add(carPlanOrderAccount);
            }
            dataTables.setData(list);
            Object o=orderRepository.countIngOrderByAccount(accounts);
            if(o==null){
               dataTables.setRecordsFiltered(0l);
            }else{
               dataTables.setRecordsFiltered(Long.valueOf(o.toString()));
            }
        }
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ZcCarAndPlan beforeOrder(Integer lei) {
        List<ZcCar>cars=carRespository.findCar(lei);
        if(cars.isEmpty()){
            return null;
        }
        Random ran=new Random();
        int s = ran.nextInt(cars.size());
        ZcCar car=cars.get(s);
        ZcPlan plan=planRepository.findOne(car.getPlanId());
        ZcCarAndPlan carPlan=new ZcCarAndPlan();
        carPlan.setCar(car);
        carPlan.setPlan(plan);
        return carPlan;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    /**页面添加订单*/
    public ZcOrder addOrderFromPage(ZcOrder zcOrder) {
        zcOrder.setFlag(0);
        ZcPlan zcPlan = planRepository.findOne(zcOrder.getPlanId());
        int days = (int)Math.ceil((zcOrder.getPlanReturnDate().getTime()-zcOrder.getZuchuDate().getTime())/(1000*60*60*24));
        zcOrder.setLimitMileage(zcPlan.getUnitMileage()*days);
        ZcCar car=carRespository.findOne(zcOrder.getCarId());
        car.setStatus(1);
        carRespository.saveAndFlush(car);
        if(zcOrder!=null && zcOrder.getId()==null ) {
            orderRepository.saveAndFlush(zcOrder);
            return zcOrder;
        }
        return null;
    }

    /** 该方法已经被弃置，不再使用！*/
 /*   public ZcOrder returnCarFromPage(Integer id, String huancheDate, Double afterMileage) throws ParseException {
        if( id == null){
            return null;
        }
        ZcOrder zcOrder = orderRepository.findOne(id);
        ZcPlan zcPlan = planRepository.findOne(zcOrder.getPlanId());
        if(zcOrder.getFlag() == 3){
            System.out.println("这个辆车已经还了！不能再进行还车操作！！等待结算中！！！");
            return null;
        }else if(zcOrder.getFlag() == 1){
            System.out.println("这个辆车已经结算完成了！不能再进行还车操作！！");
        }else if(zcOrder.getFlag() == 2){
            System.out.println("该订单已经被取消了！不能再进行还车操作！！");
        }
        zcOrder.setAfterMileage(afterMileage);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(huancheDate);
        Timestamp timestamp = new Timestamp(date.getTime());
        zcOrder.setHuancheDate(timestamp);
        if(zcOrder.getPlanReturnDate().getTime()<timestamp.getTime()){
            //超过还车时间
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(new Date(zcOrder.getPlanReturnDate().getTime()));
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date(zcOrder.getHuancheDate().getTime()));
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(new Date(zcOrder.getZuchuDate().getTime()));
            //正常约定的时间（小时）
            long time1 = (calendar1.getTimeInMillis() - calendar3.getTimeInMillis())/(60*60*1000);
            //天数
            int days =(int) Math.ceil(time1/24);
            zcOrder.setJijiatime(days);
            //存入正常约定的租金
            zcOrder.setTimePrice((zcPlan.getPrice())*days);
            //超过的小时数//
            long time2 = (calendar2.getTimeInMillis() - calendar1.getTimeInMillis())/(60*60*1000);
            int hours = (int) Math.ceil(time2);
            //存入超时的租金
            zcOrder.setOutTimePrice((zcPlan.getOutTime())*hours);
            //存入限制的里程总数
            zcOrder.setLimitMileage(zcPlan.getUnitMileage()*days);
        }else{
            //未超过还车时间
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(new Date(zcOrder.getPlanReturnDate().getTime()));
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(new Date(zcOrder.getZuchuDate().getTime()));
            long time = (calendar1.getTimeInMillis() - calendar3.getTimeInMillis())/(60*60*1000);
            int days = (int) Math.ceil(time/24);
            //存入正常约定的租金
            zcOrder.setJijiatime(days);
            zcOrder.setOutTimePrice(0.0);//超时租金为0
            //存入限制的里程总数
            zcOrder.setLimitMileage(zcPlan.getUnitMileage()*days);
        }
        if((zcOrder.getBeforeMileage()+zcOrder.getLimitMileage())<zcOrder.getAfterMileage()){
            //超出了里程数
            Double outOfMileage = zcOrder.getAfterMileage() -
                    (zcOrder.getBeforeMileage()+zcOrder.getLimitMileage());
            //存入超出里程的租金
            zcOrder.setOutMileagePrice(outOfMileage * zcPlan.getOutMileage());
        }else{
            zcOrder.setOutMileagePrice(0.0);
        }
        //改变状态，等待结算
        zcOrder.setFlag(3);
        //写入数据库
        orderRepository.saveAndFlush(zcOrder);
        return zcOrder;
    }*/
}
