package com.aiton.bmpw.Service;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Entity.Show.Zone_Web;
import com.aiton.bmpw.Entity.Zone;

import javax.servlet.http.HttpServletRequest;
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
    List<Zone_Web> updateZone() throws ServiceException, RemoteException, UnsupportedEncodingException;
    List<Zone> getsheng();
    List<Zone> getByParentID(Integer parentID);
    void defaultAvailableZones() throws RemoteException, ServiceException;
    List<Zone_Web> setoutZone();
    List<Zone_Web> arriveZone();
    Zone getZoneByID(Integer zoneID);
    Zone updateZoneFlag(Integer zoneID,Integer flag);
}
