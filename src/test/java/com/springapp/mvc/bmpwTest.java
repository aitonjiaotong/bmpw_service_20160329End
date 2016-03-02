package com.springapp.mvc;

import com.aiton.bmpw.Util.bmpwUtils;
import com.aiton.bmpw.Webservice.JDTTicketLocator;
import com.aiton.bmpw.Webservice.JDTTicketSoap_PortType;
import net.sf.json.JSONObject;
import org.junit.Test;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
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
        JDTTicketLocator jdtTicketLocator=new JDTTicketLocator();
        JDTTicketSoap_PortType jdtTicketSoap_portType=jdtTicketLocator.getJDTTicketSoap();
        String str=jdtTicketSoap_portType.queryBookLog("2016-02-26-c4df17f8-0741-4669-bb63-a4c2051d1e03");
        JSONObject jsonObject=JSONObject.fromObject(str);
        String ste=jsonObject.get("BookTime").toString();
        ste=ste.substring(ste.indexOf("(")+1,ste.indexOf(")"));
        System.out.println(ste);
    }
}
