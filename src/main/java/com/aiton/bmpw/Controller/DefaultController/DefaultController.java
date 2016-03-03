package com.aiton.bmpw.Controller.DefaultController;

import com.aiton.bmpw.Entity.Show.Zone_Web;
import com.aiton.bmpw.Entity.Zone;
import com.aiton.bmpw.Service.ZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-24
 * Time: 下午3:39
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DefaultController {
    @Resource
    private ZoneService zoneService;
    @RequestMapping("/bmpw/test3")
    @ResponseBody
    public List<Zone> exe3() throws ServiceException, RemoteException, UnsupportedEncodingException {
        List<Zone> zone_webs=zoneService.updateZone();
        return zone_webs;
    }
    @RequestMapping("/bmpw/test4")
    @ResponseBody
    public void exe4() throws ServiceException, RemoteException, UnsupportedEncodingException {
        zoneService.defaultAvailableZones();
    }
}
