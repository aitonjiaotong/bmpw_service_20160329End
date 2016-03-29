package com.springapp.mvc;

import net.sf.json.JSONObject;
import org.junit.Test;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

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
        Boolean a=true;
        JSONObject jsonObject=JSONObject.fromObject(a);
        System.out.println(jsonObject.toString());
    }
}
