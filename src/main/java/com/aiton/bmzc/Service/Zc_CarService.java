package com.aiton.bmzc.Service;

import com.aiton.bmzc.Entity.Zc_contains_num;
import com.aiton.bmzc.Entity.zc_Car;
import com.aiton.bmzc.Entity.zc_car_plan;
import com.aiton.bmzc.Entity.zc_plan;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    Zc_contains_num loadCanuseCar(Integer page);
    public boolean updateCar(zc_Car car);
    public zc_Car loadCar(String licensePlate);
}
