package com.springapp.mvc;

import com.aiton.bmpw.Entity.Zone;
import com.aiton.bmpw.Util.GsonUtils;
import com.aiton.bmpw.Util.bmpwUtils;
import com.aiton.bmpw.Webservice.JDTTicketLocator;
import com.aiton.bmpw.Webservice.JDTTicketSoap_PortType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
public class bmpwTest {
    @Test
    public void test1() throws ServiceException, RemoteException {
//        String str= bmpwUtils.StringMD5("aiton8888");
//        System.out.println(str);
//        Random ran=new Random();
//        Integer a=0;
//        for(int i=0;i<100;i++){
//            a=ran.nextInt(80)+20;
//            System.out.println(a);
//        }
//        JDTTicketLocator jdtTicketLocator=new JDTTicketLocator();
//        JDTTicketSoap_PortType jdtTicketSoap_portType=jdtTicketLocator.getJDTTicketSoap();
//        String str=jdtTicketSoap_portType.queryBookLog("2016-02-26-c4df17f8-0741-4669-bb63-a4c2051d1e03");
//        JSONObject jsonObject=JSONObject.fromObject(str);
//        String ste=jsonObject.get("BookTime").toString();
//        ste=ste.substring(ste.indexOf("(")+1,ste.indexOf(")"));
//        System.out.println(ste);
//        List<Integer>list=new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(0);
//        JSONArray jsonArray=JSONArray.fromObject(list);
//        System.out.println(jsonArray.toString());
//        String str="{\"ZoneID\":1,\"ZoneCode\":\"35\",\"ZoneName\":\"福建省\",\"ParentZoneID\":-1,\"FullCode\":\"35\",\"FullName\":\"福建省\",\"SubZones\":null}";
//        String str1="{\"Flag\":0,\"FullName\":\"福建省\",\"ZoneID\":1,\"ZoneName\":\"福建省\",\"FullCode\":\"35\",\"SubZones\":null,\"ZoneCode\":35,\"ParentZoneID\":-1}";
//        Zone zone= GsonUtils.parseJSON(str,Zone.class);
//
//        Zone zone1=GsonUtils.parseJSON(str1,Zone.class);
////        System.out.println(zone.getFullCode()+"--"+zone1.getFullCode());
////        System.out.println(zone.getFullName()+"--"+zone1.getFullName());
////        System.out.println(zone.getZoneCode()+"--"+zone1.getZoneCode());
////        System.out.println(zone.getParentZoneID()+"--"+zone1.getParentZoneID());
////        System.out.println(zone.getZoneName()+"--"+zone1.getZoneName());
////        System.out.println(zone.getZoneID()+"--"+zone1.getZoneID());
//       System.out.println(zone.equals(zone1));
//        Long time=System.currentTimeMillis();
        System.out.println(StrictMath.ceil(((double)5/2)));
    }
}
