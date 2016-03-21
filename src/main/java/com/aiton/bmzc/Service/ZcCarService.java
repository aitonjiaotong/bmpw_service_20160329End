package com.aiton.bmzc.Service;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Entity.ZcCar;
import com.aiton.bmzc.Entity.ZcContainsNum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public interface ZcCarService {
    List<ZcCar> loadCars();
    ZcCar addCar(ZcCar car,HttpServletRequest request);
    ZcContainsNum loadCanuseCar(Integer page);
    Boolean updateCar(ZcCar car);
    ZcCar loadCar(Integer id);
    DataTables loadCanuseCars(Integer draw,Integer start,Integer length,String search);
}
