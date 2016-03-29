package com.aiton.bmpw.controller.test;

import com.aiton.bmpw.dao.AccountReponstory;
import com.aiton.bmpw.dao.UserReponstory;
import com.aiton.bmpw.dao.ZoneReponsitory;
import com.aiton.bmpw.entity.Account;
import com.aiton.bmpw.entity.model.User;
import com.aiton.bmpw.entity.Site;
import com.aiton.bmpw.entity.Zone;
import com.aiton.bmpw.service.SiteService;
import com.aiton.bmpw.service.ZoneService;
import com.aiton.bmzc.service.ZcOrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TestController {
    @Resource
    private AccountReponstory accountReponstory;
    @Resource
    private UserReponstory userReponstory;
    @Resource
    private ZoneService zoneService;
    @Resource
    private ZoneReponsitory zoneReponsitory;
    @Resource
    private SiteService siteService;
    @Resource
    private ZcOrderService orderService;
    @RequestMapping("/test1")
    @ResponseBody
    public List<Account> exe1(){
        List<Account>accounts=accountReponstory.findAll();
        return accounts;
    }
    @RequestMapping("/test2")
    @ResponseBody
    public List<User> exe2(){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        List<User>users=userReponstory.findAll(new PageRequest(0,2,sort)).getContent();
        return users;
    }
    @RequestMapping("/test5")
    @ResponseBody
    public int exe5(){
       Zone zone=zoneReponsitory.findOne(15);
       int a=zone.getFullCode().length();
        return a;
    }
    @RequestMapping("/test6")
    @ResponseBody
    public List<Site> exe6() throws ServiceException, RemoteException {
        List<Site>sites=siteService.updateSites();
        return sites;
    }
    @RequestMapping("/test7")
    @ResponseBody
    public List<Zone> exe7(){
        List<Zone>zones=zoneReponsitory.getByParent(16);
        return zones;
    }
    @RequestMapping("/testpage")
    public String exe9(){
        return "test";
    }
    @RequestMapping("/test10")
    @ResponseBody
    public String exe10(){
       return null;
    }
}
