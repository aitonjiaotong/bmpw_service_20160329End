package com.aiton.bmpw.controller.frontController.ZoneAndSite;

import com.aiton.bmpw.entity.show.Zone_Web;
import com.aiton.bmpw.service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-24
 * Time: 下午5:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoadSetoutZones {
    @Resource
    private ZoneService service;
    @RequestMapping("/front/loadsetoutzone")
    @ResponseBody
    public List<Zone_Web> execute(){
        List<Zone_Web> zone_webs=service.setoutZone();
        return zone_webs;
    }
}
