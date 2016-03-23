package com.springapp.mvc;

import com.aiton.bmpw.Entity.Zone;
import com.aiton.bmpw.Util.GsonUtils;
import com.aiton.bmpw.Util.bmpwUtils;
import com.aiton.bmpw.Webservice.JDTTicketLocator;
import com.aiton.bmpw.Webservice.JDTTicketSoap_PortType;
import com.aiton.weixinapliy.ApliyUtil;
import com.aiton.weixinapliy.entity.WeixinapliyRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import javax.xml.rpc.ServiceException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
        WeixinapliyRequest req=new WeixinapliyRequest();
        req.setBody("你好");
//        JSONObject jsonObject=JSONObject.fromObject(req);
//        System.out.println(jsonObject.toString());
        String str= null;
        try {
            str = ApliyUtil.getSign(req);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(str);
    }
}
