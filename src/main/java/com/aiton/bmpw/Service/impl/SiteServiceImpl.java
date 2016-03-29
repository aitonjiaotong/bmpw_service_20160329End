package com.aiton.bmpw.service.impl;

import com.aiton.bmpw.dao.SiteReponstory;
import com.aiton.bmpw.dao.ZoneReponsitory;
import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.entity.Site;
import com.aiton.bmpw.entity.Zone;
import com.aiton.bmpw.service.SiteService;
import com.aiton.bmpw.util.GsonUtils;
import com.aiton.bmpw.Webservice.JDTTicketLocator;
import com.aiton.bmpw.Webservice.JDTTicketSoap_PortType;
import com.google.gson.reflect.TypeToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.lang.reflect.Type;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-17
 * Time: 下午6:21
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SiteServiceImpl implements SiteService{
    @Resource
    private SiteReponstory siteReponstory;
    @Resource
    private ZoneReponsitory zoneReponsitory;

    /**
     * 寻找后台筛选过的Site，给前台
     * @return
     */
    @Override
    public List<Site> findSite() {
        List<Site>list=siteReponstory.findSite();
        return list;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DataTables findAllSite(Integer draw, Integer start, Integer length,HttpServletRequest request) {
        Integer page=start/length;
        List<Site>list=new ArrayList<Site>();
        String search=request.getParameter("search[value]");
        Long count=siteReponstory.count();
        if(search==""){
            list=siteReponstory.findAll(new PageRequest(page,length)).getContent();

        }else{
            search="%"+search.toUpperCase()+"%";
            list=siteReponstory.findSiteWhereSiteCodeLike(search,new PageRequest(page,length)).getContent();
            count=Long.valueOf(siteReponstory.findCountOfSiteCoodeLike(search).toString());
        }
        for(Site site:list){
            Zone zone=zoneReponsitory.findOne(site.getZoneID());
            site.setZoneName(zone.getFullName());
        }

        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        dataTables.setRecordsTotal(siteReponstory.count());
        dataTables.setRecordsFiltered(count);
        dataTables.setData(list);
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Site> updateSites() throws ServiceException, RemoteException {
        JDTTicketLocator jdtTicketLocator=new JDTTicketLocator();
        JDTTicketSoap_PortType jdtTicketSoap_portType=jdtTicketLocator.getJDTTicketSoap();
        String sitesstr=jdtTicketSoap_portType.getSites();
        //System.out.println(sitesstr);
        Type type = new TypeToken<ArrayList<Site>>(){}.getType();
        List<Site>sites_web= GsonUtils.parseJSONArray(sitesstr,type);//金典通数据
        List<Site>sites=siteReponstory.findAll();//本地数据库数据
        if(sites.isEmpty()){
            System.out.println("数据库是空哒");
            for(Site s:sites_web){
                Site site=new Site();
                site.setFlag(1);
                site.setZoneName(s.getZoneName());
                site.setSiteCode(s.getSiteCode());
                site.setSiteID(s.getSiteID());
                site.setZoneID(s.getZoneID());
                site.setSiteName(s.getSiteName());
                siteReponstory.saveAndFlush(site);
                site=null;
            }
        }else{
            System.out.println("数据库不空");
            //判断金典通站点表是否删除
            for(Site s:sites){
                if(!sitesstr.contains("\"SiteID\":\""+s.getSiteID().toString()+"\"")){
                    siteReponstory.delete(s);
                    continue;
                }
            }
            //判断源站点是否增加或者修改
            for(Site site:sites_web){
                Site site1=siteReponstory.findOne(site.getSiteID());
                if(site1==null){
                    //有增加
                    site1=new Site();
                    site1.setSiteCode(site.getSiteCode());
                    site1.setZoneID(site.getZoneID());
                    site1.setFlag(1);
                    site1.setZoneName(site.getZoneName());
                    site1.setSiteName(site.getSiteName());
                    site1.setSiteID(site.getSiteID());
                    siteReponstory.saveAndFlush(site1);
                    continue;
                }else{
                    //有修改
                    if(!site1.getSiteCode().equals(site.getSiteCode())){
                        site1.setSiteCode(site.getSiteCode());
                    }
                    if(!site1.getSiteName().equals(site.getSiteName())){
                        site1.setSiteCode(site.getSiteName());
                    }
                    if(!site1.getZoneID().equals(site.getZoneID())){
                        site1.setZoneID(site.getZoneID());
                    }
                }
            }
        }
        return sites_web;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Site updateSiteFlag(Integer siteID) {
        //System.out.println(siteID);
        Site site=siteReponstory.findOne(siteID);
        if(site.getFlag()==1){
            site.setFlag(0);
            site=siteReponstory.saveAndFlush(site);
            return site;
        }else {
            site.setFlag(1);
            site=siteReponstory.saveAndFlush(site);
            return site;
        }

    }
}
