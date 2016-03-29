package com.aiton.bmpw.controller.frontController.ZoneAndSite;

import com.aiton.bmpw.entity.Site;
import com.aiton.bmpw.service.SiteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-26
 * Time: 下午12:48
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoadSitesController {
    @Resource
    private SiteService siteService;
    @RequestMapping("/front/loadsites")
    @ResponseBody
    public List<Site> execute(){
        List<Site>sites=siteService.findSite();
        return sites;
    }
}
