package com.aiton.bmzc.controller.driver;

import com.aiton.bmzc.entity.ZcContainsNum;
import com.aiton.bmzc.service.ZcDriverService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 下午5:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadFreeDriverController {
    @Resource
    private ZcDriverService driverService;
    @RequestMapping("/zc/driver/loadfreedriver")
    @ResponseBody
    public ZcContainsNum execute(Integer page){
        ZcContainsNum containsNum=driverService.loadDriver(page);
        return containsNum;
    }
}
