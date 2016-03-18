package com.aiton.bmzc.Service;

import com.aiton.bmzc.Entity.zc_Car;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public interface Zc_CarService {
    List<zc_Car> loadCars();
    zc_Car addCar(zc_Car car);
    List<zc_Car> loadCanuseCar();
}
