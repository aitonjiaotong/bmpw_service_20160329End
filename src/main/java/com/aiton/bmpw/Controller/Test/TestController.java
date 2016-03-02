package com.aiton.bmpw.Controller.Test;

import com.aiton.bmpw.Dao.AccountReponstory;
import com.aiton.bmpw.Dao.UserReponstory;
import com.aiton.bmpw.Dao.ZoneReponsitory;
import com.aiton.bmpw.Entity.Account;
import com.aiton.bmpw.Entity.Model.User;
import com.aiton.bmpw.Entity.Show.Zone_Web;
import com.aiton.bmpw.Entity.Site;
import com.aiton.bmpw.Entity.Zone;
import com.aiton.bmpw.Service.SiteService;
import com.aiton.bmpw.Service.ZoneService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
}
