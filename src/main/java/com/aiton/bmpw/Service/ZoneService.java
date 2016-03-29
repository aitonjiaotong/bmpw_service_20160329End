package com.aiton.bmpw.service;

import com.aiton.bmpw.entity.show.Zone_Web;
import com.aiton.bmpw.entity.Zone;

import javax.xml.rpc.ServiceException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 上午10:12
 * To change this template use File | Settings | File Templates.
 */
public interface ZoneService {
    List<Zone> updateZone() throws ServiceException, RemoteException, UnsupportedEncodingException;
    List<Zone> getsheng();
    List<Zone> getByParentID(Integer parentID);
    void defaultAvailableZones() throws RemoteException, ServiceException;
    List<Zone_Web> setoutZone();
    List<Zone_Web> arriveZone();
    Zone getZoneByID(Integer zoneID);
    Zone updateZoneFlag(Integer zoneID,Integer flag);
}
