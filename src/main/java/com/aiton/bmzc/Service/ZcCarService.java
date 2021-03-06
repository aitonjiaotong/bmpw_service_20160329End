package com.aiton.bmzc.service;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmzc.entity.ZcCar;
import com.aiton.bmzc.entity.ZcContainsNum;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public interface ZcCarService {
    DataTables loadCars(Integer draw,Integer start,Integer length,HttpServletRequest request);
    ZcCar addCar(ZcCar car,HttpServletRequest request);
    ZcContainsNum loadCanuseCar(Integer page);
    Boolean updateCar(ZcCar car);
    ZcCar loadCar(Integer id);
    DataTables loadCanuseCars(Integer draw,Integer start,Integer length,String search);
    boolean deleteCar(Integer id);
}
