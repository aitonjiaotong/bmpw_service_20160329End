package com.aiton.bmzc.Service.Impl;

import com.aiton.bmzc.Dao.zc_CarRespository;
import com.aiton.bmzc.Entity.zc_Car;
import com.aiton.bmzc.Service.Zc_CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Override
    public List<zc_Car> loadCars() {
        List<zc_Car>cars=carRespository.findAll();
        return cars;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public zc_Car addCar(zc_Car car) {
        car=carRespository.saveAndFlush(car);
        return car;  //To change body of implemented methods use File | Settings | File Templates.
    }
    //查找可以出租的车辆
    @Override
    public List<zc_Car> loadCanuseCar() {
        List<zc_Car>cars=carRespository.findCanUseCar();
        return cars;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
