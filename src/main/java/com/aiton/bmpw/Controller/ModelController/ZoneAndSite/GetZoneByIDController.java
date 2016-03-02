package com.aiton.bmpw.Controller.ModelController.ZoneAndSite;

import com.aiton.bmpw.Entity.Zone;
import com.aiton.bmpw.Service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-26
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GetZoneByIDController {
    @Resource
    private ZoneService zoneService;
    @RequestMapping("/zone/getzonebyid")
    @ResponseBody
    public Zone execute(Integer zoneID){
        Zone zone=zoneService.getZoneByID(zoneID);
        return zone;
    }
}
