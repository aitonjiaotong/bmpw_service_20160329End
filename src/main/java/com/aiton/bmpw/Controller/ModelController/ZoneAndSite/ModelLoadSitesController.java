package com.aiton.bmpw.controller.modelController.ZoneAndSite;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.service.SiteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-26
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ModelLoadSitesController {
    @Resource
    private SiteService siteService;
    @RequestMapping("/site/loadsites")
    @ResponseBody
    public DataTables execute(Integer draw, Integer start, Integer length,HttpServletRequest request){
        DataTables dataTables=siteService.findAllSite(draw,start,length,request);
        return dataTables;
    }
}
