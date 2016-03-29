package com.aiton.bmzc.controller.car;

import com.aiton.bmzc.entity.ZcContainsNum;
import com.aiton.bmzc.service.ZcCarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadCanUseCarController {
    @Resource
    private ZcCarService carService;
    @RequestMapping("/zc/front/loadcanusecar")
    @ResponseBody
    public ZcContainsNum execute(Integer page){
        ZcContainsNum containsNum=carService.loadCanuseCar(page);
        return containsNum;
    }
}
