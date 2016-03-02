package com.aiton.bmpw.Controller.FrontController.ZoneAndSite;

import com.aiton.bmpw.Entity.Show.Zone_Web;
import com.aiton.bmpw.Service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-24
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoadArriveZoneController {
    @Resource
    private ZoneService service;
    @RequestMapping("/front/loadarrivezone")
    @ResponseBody
    public List<Zone_Web> execute(){
        List<Zone_Web> zone_webs=service.arriveZone();
        return zone_webs;
    }
}
