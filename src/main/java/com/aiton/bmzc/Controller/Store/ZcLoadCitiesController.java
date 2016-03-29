package com.aiton.bmzc.controller.Store;

import com.aiton.bmzc.entity.ZcContainsNum;
import com.aiton.bmzc.service.ZcStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 上午9:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadCitiesController {
    @Resource
    private ZcStoreService storeService;
    @RequestMapping("/zc/store/loadcities")
    @ResponseBody
    public ZcContainsNum execute(Integer page){
        ZcContainsNum cities=storeService.loadCity(page);
        return cities;
    }
}
