package com.aiton.bmpw.controller.modelController.ZoneAndSite;

import com.aiton.bmpw.entity.Site;
import com.aiton.bmpw.service.SiteService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 上午10:48
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class UpdateSiteFlagController {
    @Resource
    private SiteService siteService;
    @RequestMapping("/site/updatesiteflag")
    @ResponseBody
    public Site execute(Integer siteID){
        //System.out.println(siteID);
        Site site=siteService.updateSiteFlag(siteID);
        return site;
    }
}
