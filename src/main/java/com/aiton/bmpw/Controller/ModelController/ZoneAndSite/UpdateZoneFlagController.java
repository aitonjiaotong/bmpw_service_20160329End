package com.aiton.bmpw.controller.modelController.ZoneAndSite;

import com.aiton.bmpw.entity.Zone;
import com.aiton.bmpw.service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-26
 * Time: 下午3:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class UpdateZoneFlagController {
    @Resource
    private ZoneService zoneService;
    @RequestMapping("/zone/updatezoneflag")
    @ResponseBody
    public Zone execute(Integer zoneID,Integer flag){
        Zone zone=zoneService.updateZoneFlag(zoneID,flag);
        return zone;
    }
}
