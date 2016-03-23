package com.springapp.mvc;

import com.aiton.bmpw.Entity.Zone;
import com.aiton.bmpw.Util.GsonUtils;
import com.aiton.bmpw.Util.bmpwUtils;
import com.aiton.bmpw.Webservice.JDTTicketLocator;
import com.aiton.bmpw.Webservice.JDTTicketSoap_PortType;
import com.aiton.wxApliy.entity.WxRequest;
import com.aiton.wxApliy.service.WxConnection;
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
        WxConnection c=new WxConnection();
        WxRequest request=new WxRequest();
        System.out.println(c.reqOrder(request));
    }
}
