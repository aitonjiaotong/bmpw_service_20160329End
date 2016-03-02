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
    public List<Zone_Web> updateZone() throws UnsupportedEncodingException, ServiceException, RemoteException {
        JDTTicketLocator jdtTicketLocator=new JDTTicketLocator();
        JDTTicketSoap_PortType jdtTicketSoap_portType=jdtTicketLocator.getJDTTicketSoap();
        String zones=jdtTicketSoap_portType.getZones();
        //System.out.println(zones);
        Type type = new TypeToken<ArrayList<Zone>>(){}.getType();
        List<Zone_Web>list=GsonUtils.parseJSONArray(zones,type);
        List<Zone>zones1=zoneReponsitory.findAll();
        //System.out.println(list.size());
        if(zones1.isEmpty()){
            //System.out.println("zones1为null");
            for(Zone_Web zone_web:list){
                Zone zone=new Zone();
                zone.setFlag(3);
                zone.setZoneName(zone_web.getZoneName());
                zone.setFullName(zone_web.getFullName());
                zone.setFullCode(zone_web.getFullCode());
                zone.setParentZoneID(zone_web.getParentZoneID());
                zone.setSubZones(null);
                zone.setZoneCode(zone_web.getZoneCode());
                zone.setZoneID(zone_web.getZoneID());
                System.out.println(zone.getZoneID());
                zoneReponsitory.saveAndFlush(zone);
                zone=null;
            }
        }else{
            System.out.println("zones1不是0");
           // System.out.println(zones.contains("\"ZoneID\":29"));

            for(Zone zone:zones1){
                //zone_web是否删除了对象
                if(!zones.contains("\"ZoneID\":"+zone.getZoneID())){
                    zoneReponsitory.delete(zone);
                    continue;
                }
            }
            //zone_web是否增改对象
            for(Zone_Web zone_web:list){
               Zone zone1=zoneReponsitory.findOne(zone_web.getZoneID());
                //是否增加
                if(zone1==null){
                    //增加了
                    Zone zone=new Zone();
                    zone.setFlag(3);
                    zone.setZoneName(zone_web.getZoneName());
                    zone.setFullName(zone_web.getFullName());
                    zone.setFullCode(zone_web.getFullCode());
                    zone.setParentZoneID(zone_web.getParentZoneID());
                    zone.setSubZones(null);
                    zone.setZoneCode(zone_web.getZoneCode());
                    zone.setZoneID(zone_web.getZoneID());
                    System.out.println(zone.getZoneID());
                    zoneReponsitory.saveAndFlush(zone);
                    zone=null;
                }
                //是否修改
                if(!zone1.getFullCode().equals(zone_web.getFullCode()) ){
                    zone1.setFullCode(zone_web.getFullCode());
                }
                if(!zone1.getZoneName().equals(zone_web.getZoneName())){
                    zone1.setZoneName(zone_web.getZoneName());
                }
                if(!zone1.getFullName().equals(zone_web.getFullName())){
                    zone1.setFullName(zone_web.getFullName());
                }
                if(!zone1.getParentZoneID().equals(zone_web.getParentZoneID())){
                    zone1.setParentZoneID(zone_web.getParentZoneID());
                }
                if(!zone1.getZoneCode().equals(zone_web.getZoneCode())){
                    zone1.setZoneCode(zone_web.getParentZoneID());
                }
                zoneReponsitory.saveAndFlush(zone1);
                System.out.println(zone1.getZoneID());
            }


        }
        return list;
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
        List<Zone>zones=zoneReponsitory.getCanSetoutZone();
        List<Zone_Web>zone_webs=new ArrayList<Zone_Web>();
        for(Zone zone:zones){
            Zone_Web zone_web= bmpwUtils.setZonetoZone_Web(zone);
            zone_webs.add(zone_web);
        }
        //镇与市关联,将镇变成集合
        Map<Integer,List<Zone_Web>>zhenMap=new HashMap<Integer, List<Zone_Web>>();
        for(Zone_Web zone_web:zone_webs){
            //System.out.println(zone_web.getFullCode().length());
            if(zone_web.getFullCode().length()==6){
                 if(zhenMap.get(zone_web.getParentZoneID())==null){
                     List<Zone_Web>zhen=new ArrayList<Zone_Web>();
                     zhen.add(zone_web);
                     zhenMap.put(zone_web.getParentZoneID(),zhen);
                 }else{
                     List<Zone_Web>zhen=zhenMap.get(zone_web.getParentZoneID());
                     zhen.add(zone_web);
                     zhenMap.put(zone_web.getParentZoneID(),zhen);
                 }
            }
        }
        //将镇装配到市
        List<Zone_Web>shiList=new ArrayList<Zone_Web>();
        Map<Integer,List<Zone_Web>>shiMap=new HashMap<Integer, List<Zone_Web>>();
        Set<Integer>shizoneIDs=zhenMap.keySet();
        for(Integer shizoneID:shizoneIDs){
            Zone zone=zoneReponsitory.findOne(shizoneID);
            Zone_Web zone_web=bmpwUtils.setZonetoZone_Web(zone);
            zone_web.setSubZones(zhenMap.get(shizoneID));
            shiList.add(zone_web);
        }
        //将市装配到省
        for(Zone_Web zone_web:shiList){
            if(shiMap.get(zone_web.getParentZoneID())==null){
                List<Zone_Web> shi=new ArrayList<Zone_Web>();
                shi.add(zone_web);
                shiMap.put(zone_web.getParentZoneID(),shi);
            }else{
                List<Zone_Web> shi=shiMap.get(zone_web.getParentZoneID());
                shi.add(zone_web);
                shiMap.put(zone_web.getParentZoneID(),shi);
            }
        }
        List<Zone_Web>sheng=new ArrayList<Zone_Web>();
        Set<Integer>shengzoneIDs=shiMap.keySet();
        for(Integer shengzoneID:shengzoneIDs){
            //System.out.println(shengzoneID);
            Zone zone=zoneReponsitory.findOne(shengzoneID);
            Zone_Web zone_web=bmpwUtils.setZonetoZone_Web(zone);
            zone_web.setSubZones(shiMap.get(shengzoneID));
            sheng.add(zone_web);
        }
        zone_webs=null;
        return sheng;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Zone_Web> arriveZone() {
        List<Zone>zones=zoneReponsitory.getArriveZone();
        List<Zone_Web>zone_webs=new ArrayList<Zone_Web>();
        for(Zone zone:zones){
            Zone_Web zone_web= bmpwUtils.setZonetoZone_Web(zone);
            zone_webs.add(zone_web);
        }
        //镇与市关联,将镇变成集合
        Map<Integer,List<Zone_Web>>zhenMap=new HashMap<Integer, List<Zone_Web>>();
        for(Zone_Web zone_web:zone_webs){
            //System.out.println(zone_web.getFullCode().length());
            if(zone_web.getFullCode().length()==6){
                if(zhenMap.get(zone_web.getParentZoneID())==null){
                    List<Zone_Web>zhen=new ArrayList<Zone_Web>();
                    zhen.add(zone_web);
                    zhenMap.put(zone_web.getParentZoneID(),zhen);
                }else{
                    List<Zone_Web>zhen=zhenMap.get(zone_web.getParentZoneID());
                    zhen.add(zone_web);
                    zhenMap.put(zone_web.getParentZoneID(),zhen);
                }
            }
        }
        //将镇装配到市
        List<Zone_Web>shiList=new ArrayList<Zone_Web>();
        Map<Integer,List<Zone_Web>>shiMap=new HashMap<Integer, List<Zone_Web>>();
        Set<Integer>shizoneIDs=zhenMap.keySet();
        for(Integer shizoneID:shizoneIDs){
            Zone zone=zoneReponsitory.findOne(shizoneID);
            Zone_Web zone_web=bmpwUtils.setZonetoZone_Web(zone);
            zone_web.setSubZones(zhenMap.get(shizoneID));
            shiList.add(zone_web);
        }
        //将市装配到省
        for(Zone_Web zone_web:shiList){
            //System.out.println(zone_web.getParentZoneID());
            if(shiMap.get(zone_web.getParentZoneID())==null){
                List<Zone_Web> shi=new ArrayList<Zone_Web>();
                shi.add(zone_web);
                shiMap.put(zone_web.getParentZoneID(),shi);
            }else{
                List<Zone_Web> shi=shiMap.get(zone_web.getParentZoneID());
                shi.add(zone_web);
                shiMap.put(zone_web.getParentZoneID(),shi);

            }
        }

        List<Zone_Web>sheng=new ArrayList<Zone_Web>();
        Set<Integer>shengzoneIDs=shiMap.keySet();
        for(Integer shengzoneID:shengzoneIDs){
            //System.out.println(shengzoneID);
            Zone zone=zoneReponsitory.findOne(shengzoneID);
            Zone_Web zone_web=bmpwUtils.setZonetoZone_Web(zone);
            zone_web.setSubZones(shiMap.get(shengzoneID));
            sheng.add(zone_web);
        }
        zone_webs=null;
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
