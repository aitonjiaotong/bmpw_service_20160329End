package com.aiton.bmzc.Controller.Car;

import com.aiton.bmzc.Entity.Zc_contains_num;
import com.aiton.bmzc.Entity.zc_Car;
import com.aiton.bmzc.Entity.zc_car_plan;
import com.aiton.bmzc.Entity.zc_plan;
import com.aiton.bmzc.Service.Zc_CarService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class zc_FreeCarController {
    @Resource
    private Zc_CarService carService;
    @RequestMapping("/zc/car/loadcanusecar")
    @ResponseBody
    public Zc_contains_num execute(Integer page){
        Zc_contains_num cars=carService.loadCanuseCar(page);
        return cars;
    }
}
