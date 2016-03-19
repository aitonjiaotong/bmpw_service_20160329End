package com.aiton.bmzc.Service;

import com.aiton.bmzc.Entity.zc_Car;
import com.aiton.bmzc.Entity.zc_car_plan;

import javax.servlet.http.HttpServletRequest;
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
    zc_Car addCar(zc_Car car,HttpServletRequest request);
    List<zc_car_plan> loadCanuseCar(Integer page);
    boolean updateCar(zc_Car car);
    zc_Car loadCar(String car_id);
}
