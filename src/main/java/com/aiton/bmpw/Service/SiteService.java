package com.aiton.bmpw.service;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.entity.Site;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-17
 * Time: 下午5:41
 * To change this template use File | Settings | File Templates.
 */
public interface SiteService {
    List<Site> findSite();
    DataTables findAllSite(Integer draw,Integer start,Integer length,HttpServletRequest request);
    List<Site> updateSites() throws ServiceException, RemoteException;
    Site updateSiteFlag(Integer siteID);
}
