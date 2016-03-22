package com.aiton.bmzc.Service.Impl;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Dao.ZcCarRespository;
import com.aiton.bmzc.Dao.ZcPlanRepository;
import com.aiton.bmzc.Entity.ZcCar;
import com.aiton.bmzc.Entity.ZcCarPlan;
import com.aiton.bmzc.Entity.ZcContainsNum;
import com.aiton.bmzc.Entity.ZcPlan;
import com.aiton.bmzc.Service.ZcCarService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 下午2:45
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ZcCarServiceImpl implements ZcCarService {
    @Resource
    private ZcCarRespository carRespository;
    @Resource
    private ZcPlanRepository planRepository;
    /**
     * 占位，后期利用DataTables的
     * @return
     */
    @Override
    public DataTables loadCars(Integer draw,Integer start,Integer length,HttpServletRequest request) {
        Integer page=start/length;
        String search=request.getParameter("search[value]");
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        dataTables.setRecordsFiltered(carRespository.count());
        if(search==null||"".equals(search)){
            dataTables.setData(carRespository.findAll(new PageRequest(page,length)).getContent());
            dataTables.setRecordsFiltered(carRespository.count());
        }else{
            search="%"+search+"%";
            dataTables.setData(carRespository.findCarsLicensePlateLike(search,new PageRequest(page,length)));
            Object o=carRespository.countCarsLicensePlateLike(search);
            if(o==null){
                dataTables.setRecordsFiltered(0l);
            }else{
                dataTables.setRecordsFiltered(Long.valueOf(o.toString()));
            }

        }
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ZcCar addCar(ZcCar car,HttpServletRequest request) {
        if(carRespository.findOne(car.getId())!=null){
            return null;
        }
        ServletContext context=request.getServletContext();
        car.setStatus(0);
        String str=context.getRealPath("/");
        String path=str+"WEB-INF"+File.separator+"pages"+File.separator+"cars"+File.separator;
        File file=new File(path);
        File[]files=file.listFiles();
        for(File f:files){
           String name=f.getName();
           String extName=name.substring(name.lastIndexOf("."));
           if(name.equals(car.getId()+extName)){
               car.setImage("http://120.55.166.203:8080/bmpw/cars/"+name);
           }
        }
        try{
            car=carRespository.saveAndFlush(car);
        }catch(Exception e){
            return null;
        }
        return car;  //To change body of implemented methods use File | Settings | File Templates.
    }
    //查找可以出租的车辆
    @Override
    public ZcContainsNum loadCanuseCar(Integer page) {
        List<ZcCarPlan>cars=carRespository.findCanUseCar(new PageRequest(page,8));
//        for(int i=0;i<cars.size();i++){
//
//        }
        for(ZcCarPlan car:cars){
            ZcPlan plan=planRepository.findOne(car.getPlan_id());
            car.setPlan(plan);
        }
        ZcContainsNum contains_num=new ZcContainsNum();
        contains_num.setContains(cars);
        List<ZcCarPlan>car_plans=carRespository.CountCanUseCar();
        contains_num.setNum((int)Math.ceil((double)car_plans.size()/8));
        return contains_num;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    /**更新车辆信息*/
    public Boolean updateCar(ZcCar car) {
        try {
            carRespository.saveAndFlush(car);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public ZcCar loadCar(Integer id) {
        ZcCar car = carRespository.findOne(id);
        return car;
    }

    @Override
    public DataTables loadCanuseCars(Integer draw, Integer start, Integer length, String search) {
        Integer page=start/length;
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        List<ZcCarPlan>car_plans=carRespository.CountCanUseCar();
        dataTables.setRecordsTotal((long)car_plans.size());
        if(search==null||"".equals(search)){
            dataTables.setRecordsFiltered((long)car_plans.size());
            dataTables.setData(carRespository.findCanUseCar(new PageRequest(page,length)));
        }
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
