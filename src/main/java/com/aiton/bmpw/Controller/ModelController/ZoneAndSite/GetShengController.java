package com.aiton.bmpw.controller.modelController.ZoneAndSite;

import com.aiton.bmpw.entity.Zone;
import com.aiton.bmpw.service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-26
 * Time: 上午11:51
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GetShengController {
    @Resource
    private ZoneService zoneService;
    @RequestMapping("/zone/shengs")
    @ResponseBody
    public List<Zone> execute(){
        List<Zone>zones=zoneService.getsheng();
        return zones;
    }
}
