package com.aiton.bmpw.Service.impl;

import com.aiton.bmpw.Dao.ZoneReponsitory;
import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Entity.Show.Zone_Web;
import com.aiton.bmpw.Entity.Zone;
import com.aiton.bmpw.Service.ZoneService;
import com.aiton.bmpw.Util.GsonUtils;
import com.aiton.bmpw.Util.bmpwUtils;
import com.aiton.bmpw.Webservice.JDTTicketLocator;
import com.aiton.bmpw.Webservice.JDTTicketSoap_PortType;

import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.rmi.RemoteException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ZoneServiceImpl implements ZoneService {
    @Resource
    private ZoneReponsitory zoneReponsitory;
    @Override
    public List<Zone> updateZone() throws UnsupportedEncodingException, ServiceException, RemoteException {
        JDTTicketLocator jdtTicketLocator=new JDTTicketLocator();
        JDTTicketSoap_PortType jdtTicketSoap_portType=jdtTicketLocator.getJDTTicketSoap();
        String zones=jdtTicketSoap_portType.getZones();
        //System.out.println(zones);
        Type type = new TypeToken<ArrayList<Zone>>(){}.getType();
        List<Zone>zone_web=GsonUtils.parseJSONArray(zones,type);
        List<Zone>zone=zoneReponsitory.findAll();
        if(zone.isEmpty()){
            for(Zone z:zone_web){
                Zone zone1=new Zone();
                zone1.setFlag(3);
                zone1.setFullName(z.getFullName());
                zone1.setZoneCode(z.getZoneCode());
                zone1.setZoneName(z.getZoneName());
                zone1.setParentZoneID(z.getParentZoneID());
                zone1.setFullCode(z.getFullCode());
                zone1.setZoneID(zone1.getZoneID());
                zoneReponsitory.saveAndFlush(zone1);
            }
        }else{
            //增删改
            //金典通删除了
                for(Zone zone1:zone){
                    if(!zones.contains("\"ZoneID\":"+zone1.getZoneID())){
                        zoneReponsitory.delete(zone1);

                    }
                }
           //金典通增加了
                JSONArray jsonArray=JSONArray.fromObject(zone);
                String o=jsonArray.toString();
                for(Zone zone1:zone_web){
                    //增加了
                    if(!o.contains("\"zoneID\":"+zone1.getZoneID())){
                        Zone zone2=new Zone();
                        zone2.setFlag(3);
                        zone2.setFullName(zone1.getFullName());
                        zone2.setZoneCode(zone1.getZoneCode());
                        zone2.setZoneName(zone1.getZoneName());
                        zone2.setParentZoneID(zone1.getParentZoneID());
                        zone2.setFullCode(zone1.getFullCode());
                        zone2.setZoneID(zone1.getZoneID());
                        zoneReponsitory.saveAndFlush(zone2);
                    }
                }

            for(Zone zone1:zone_web){
                for(Zone zone2:zone){
                    if(zone1.getZoneID()==zone2.getZoneID()){
                         if(!zone1.equals(zone2)){
                             zone2.setFullName(zone1.getFullName());
                             zone2.setZoneCode(zone1.getZoneCode());
                             zone2.setZoneName(zone1.getZoneName());
                             zone2.setParentZoneID(zone1.getParentZoneID());
                             zone2.setFullCode(zone1.getFullCode());
                             zone2.setZoneID(zone1.getZoneID());
                             zoneReponsitory.saveAndFlush(zone2);
                         }
                    }
                }
            }
        }
        return zone;
    }

    /**
     *
     */
    @Override
    public void defaultAvailableZones() throws RemoteException, ServiceException {
        JDTTicketLocator jdtTicketLocator=new JDTTicketLocator();
        JDTTicketSoap_PortType jdtTicketSoap_portType=jdtTicketLocator.getJDTTicketSoap();
        String zones=jdtTicketSoap_portType.getAvailableZones();
        Type type = new TypeToken<ArrayList<Zone_Web>>(){}.getType();
        List<Zone_Web>zone_webs=GsonUtils.parseJSONArray(zones,type);
        List<Zone>zones1=zoneReponsitory.findAll();
        String[] strs=zones.split("\"ZoneID\":");
        List<Integer>zoneIDs=new ArrayList<Integer>();
        for(String str:strs){
            int index=str.indexOf(",",1);
            if(index==-1){
                continue;
            }
            //System.out.println(str.substring(0, index));
            str=str.substring(0, index);
            Integer zoneID=Integer.valueOf(str.trim());
            zoneIDs.add(zoneID);
            zoneID=null;
        }
//        for(Integer zone:zoneIDs){
//            System.out.println(zone);
//        }
        for(Integer zoneID:zoneIDs){
            Zone zone=zoneReponsitory.findOne(zoneID);
            zone.setFlag(2);
            zoneReponsitory.saveAndFlush(zone);
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 获取出发地
     * @return
     */
    @Override
    public List<Zone_Web> setoutZone() {
        List<Zone>azones=zoneReponsitory.getCanSetoutZone();
        List<Zone_Web>zones=new ArrayList<Zone_Web>();
        for(Zone zone:azones){
            Zone_Web zone_web=bmpwUtils.setZonetoZone_Web(zone);
            List<Zone_Web>webs=new ArrayList<Zone_Web>();
            zone_web.setSubZones(webs);
            zones.add(zone_web);
        }
        List<Zone_Web>sheng=new ArrayList<Zone_Web>();
        Iterator<Zone_Web>iterator=zones.iterator();
        while(iterator.hasNext()){
            Zone_Web zone_web=iterator.next();
            if(zone_web.getParentZoneID()==-1){
                sheng.add(zone_web);
                iterator.remove();
            }
        }

        for(Zone_Web p:sheng){
            System.out.println(p.getZoneName());
            System.out.println(p.getZoneID());
            iterator=zones.iterator();
            while (iterator.hasNext()){
                Zone_Web zone_web=iterator.next();
                if(zone_web.getParentZoneID().equals(p.getZoneID())){
                    System.out.println(zone_web.getZoneName());
                    p.getSubZones().add(zone_web);
                    iterator.remove();
                }
            }
        }
        for(Zone_Web p:sheng){
            List<Zone_Web> cities=p.getSubZones();
            for(Zone_Web c:cities){
                iterator=zones.iterator();
                while(iterator.hasNext()){
                    Zone_Web zone_web=iterator.next();
                    if(zone_web.getParentZoneID().equals(c.getZoneID())){
                        c.getSubZones().add(zone_web);
                        iterator.remove();
                    }
                }
            }
        }
        return sheng;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Zone_Web> arriveZone() {
        List<Zone>azones=zoneReponsitory.getArriveZone();
        List<Zone_Web>zones=new ArrayList<Zone_Web>();
        for(Zone zone:azones){
            Zone_Web zone_web=bmpwUtils.setZonetoZone_Web(zone);
            List<Zone_Web>webs=new ArrayList<Zone_Web>();
            zone_web.setSubZones(webs);
            zones.add(zone_web);
        }
        List<Zone_Web>sheng=new ArrayList<Zone_Web>();
        Iterator<Zone_Web>iterator=zones.iterator();
        while(iterator.hasNext()){
            Zone_Web zone_web=iterator.next();
            if(zone_web.getParentZoneID()==-1){
                sheng.add(zone_web);
                iterator.remove();
            }
        }

        for(Zone_Web p:sheng){
            System.out.println(p.getZoneName());
            System.out.println(p.getZoneID());
            iterator=zones.iterator();
            while (iterator.hasNext()){
                Zone_Web zone_web=iterator.next();
                if(zone_web.getParentZoneID().equals(p.getZoneID())){
                    System.out.println(zone_web.getZoneName());
                    p.getSubZones().add(zone_web);
                    iterator.remove();
                }
            }
        }
        for(Zone_Web p:sheng){
            List<Zone_Web> cities=p.getSubZones();
            for(Zone_Web c:cities){
                iterator=zones.iterator();
                while(iterator.hasNext()){
                    Zone_Web zone_web=iterator.next();
                    if(zone_web.getParentZoneID().equals(c.getZoneID())){
                        c.getSubZones().add(zone_web);
                        iterator.remove();
                    }
                }
            }
        }
        return sheng;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Zone> getsheng() {
        List<Zone> zones=zoneReponsitory.getbylength("__");
        return zones;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Zone> getByParentID(Integer parentID) {
        List<Zone>zones=zoneReponsitory.getByParent(parentID);
        return zones;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Zone getZoneByID(Integer zoneID) {
        Zone zone=zoneReponsitory.findOne(zoneID);
        return zone;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Zone updateZoneFlag(Integer zoneID, Integer flag) {
        Zone zone=zoneReponsitory.findOne(zoneID);
        zone.setFlag(flag);
        zone=zoneReponsitory.saveAndFlush(zone);
        return zone;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
