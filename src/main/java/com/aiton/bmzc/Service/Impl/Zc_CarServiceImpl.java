package com.aiton.bmzc.Service.Impl;

import com.aiton.bmzc.Dao.zc_CarRespository;
import com.aiton.bmzc.Dao.zc_PlanRepository;
import com.aiton.bmzc.Entity.Zc_contains_num;
import com.aiton.bmzc.Entity.zc_Car;
import com.aiton.bmzc.Entity.zc_car_plan;
import com.aiton.bmzc.Entity.zc_plan;
import com.aiton.bmzc.Service.Zc_CarService;
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
public class Zc_CarServiceImpl implements Zc_CarService {
    @Resource
    private zc_CarRespository carRespository;
    @Resource
    private zc_PlanRepository planRepository;
    /**
     * 占位，后期利用DataTables的
     * @return
     */
    @Override
    public List<zc_Car> loadCars() {
        List<zc_Car>cars=carRespository.findAll();
        return cars;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public zc_Car addCar(zc_Car car,HttpServletRequest request) {
        ServletContext context=request.getServletContext();
        car.setStatus(0);
        String str=context.getRealPath("/");
        String path=str+"WEB-INF"+File.separator+"pages"+File.separator+"cars"+File.separator;
        File file=new File(path);
        File[]files=file.listFiles();
        for(File f:files){
           String name=f.getName();
           String extName=name.substring(name.lastIndexOf("."));
           if(name.equals(car.getLicensePlate()+extName)){
               car.setImage("http://120.55.166.203:8080/bmpw/cars/"+name);
           }
        }
        car=carRespository.saveAndFlush(car);
        return car;  //To change body of implemented methods use File | Settings | File Templates.
    }
    //查找可以出租的车辆
    @Override
    public Zc_contains_num loadCanuseCar(Integer page) {
        List<zc_car_plan>cars=carRespository.findCanUseCar(new PageRequest(page,8));
//        for(int i=0;i<cars.size();i++){
//
//        }
        for(zc_car_plan car:cars){
            zc_plan plan=planRepository.findOne(car.getPlan_id());
            car.setPlan(plan);
        }
        Zc_contains_num contains_num=new Zc_contains_num();
        contains_num.setContains(cars);
        List<zc_car_plan>car_plans=carRespository.CountCanUseCar();
        contains_num.setNum((int)Math.ceil((double)car_plans.size()/8));
        return contains_num;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    /**更新车辆信息*/
    public boolean updateCar(zc_Car car) {
        try {
            carRespository.saveAndFlush(car);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public zc_Car loadCar(String licensePlate) {
        zc_Car car = carRespository.findOne(licensePlate);
        return car;
    }


}
