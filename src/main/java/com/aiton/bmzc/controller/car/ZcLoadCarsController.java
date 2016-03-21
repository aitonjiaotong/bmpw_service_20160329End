package com.aiton.bmzc.controller.car;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Service.ZcCarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 下午7:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadCarsController {
    @Resource
    private ZcCarService zcCarService;
    @RequestMapping("/zc/car/loadcars")
    @ResponseBody
    public DataTables execute(Integer draw,Integer start,Integer length,HttpServletRequest request){
         DataTables dataTables=zcCarService.loadCars(draw,start,length,request);
        return dataTables;
    }
}
