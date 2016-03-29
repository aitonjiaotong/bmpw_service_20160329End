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
 * Time: 下午12:23
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GetZoneByParentController {
    @Resource
    private ZoneService zoneService;
    @RequestMapping("/zone/getbyparentid")
    @ResponseBody
    public List<Zone> execute(Integer parentID){
        List<Zone>zones=zoneService.getByParentID(parentID);
        return zones;
    }
}
