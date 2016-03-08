package com.aiton.bmgj.controller;

import com.aiton.bmgj.dao.*;

import com.aiton.bmgj.entity.*;
import com.aiton.bmgj.service.serviceUtil.GetData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;



/**
 * 获取数据Controller
 * Created by user on 2016/3/3.
 */
@Controller
public class TestController2 {

    @Resource
    private GetData getData;

    @Resource
    private BusRepostory busRepostory;
    @Resource
    private BusLineRepository busLineRepository;
    @Resource
    private DriverRepository driverRepository;
    @Resource
    private StationRepository stationRepository;
    @Resource
    private StationBaseRepository stationBaseRepository;

    /**测试用Controller*/
    @RequestMapping("/toTest")
    @ResponseBody
    public String getDataTest() throws UnsupportedEncodingException {
        String jsonstr = getData.getPlanRunTime(new Date());
        if(jsonstr == null){
           System.out.println("返回的数据是空的！~~~");
            return "json is empty!!!";
        }
        JSONObject br = JSONObject.fromObject(jsonstr);
        jsonstr = new String(jsonstr.getBytes("utf-8"),"ISO-8859-1");
        return jsonstr;
    }

    /**获取站点基础信息*/
    @RequestMapping("/toGetSationBaseData")
    @ResponseBody
    public String getStationBaseData(){
        String jsonstr = getData.getStationBase();
        if(jsonstr == null){
            System.out.println("返回的数据是空的！~~~");
            return "json is empty!!!";
        }
        JSONArray jsonArray = JSONObject.fromObject(jsonstr)
                .getJSONObject("Content")
                .getJSONArray("Records");
        Collection<StationBase> list = (Collection)JSONArray
                .toCollection(jsonArray, StationBase.class);
        for(StationBase stationBase : list){
            stationBaseRepository.saveAndFlush(stationBase);
        }
      //  System.out.println("*********我是分割线********信息推送本地数据库成功！******");
        return "successful!!!!";
    }

    /**获取站点信息并存入本地数据库*/
    @RequestMapping("/toGetStationData")
    @ResponseBody
    public String getStationData() {
        String jsonstr = getData.getStation();
        if(jsonstr == null){
            System.out.println("返回的数据是空的！~~~");
            return "json is empty!!!";
        }
        JSONObject jsonObject = JSONObject.fromObject(jsonstr);
        JSONObject jsonObject1 = jsonObject.getJSONObject("Content");
        JSONArray jsonArray = jsonObject1.getJSONArray("Records");
        int index = 0;
        System.out.println("我是分割线***********************");
        for(int i=0;i<jsonArray.size();i++){
            JSONObject o = jsonArray.getJSONObject(i);
            Integer busline_id = o.getInt("busline_id");
            JSONArray array = o.getJSONArray("BuslineStationModels");
            for(int j=0;j<array.size();j++){
                JSONObject object = array.getJSONObject(j);
                Station s = new Station();
                s.setUp_down(object.getInt("up_down"));
                s.setBusLineId(busline_id);
                s.setStation_id(object.getInt("station_id"));
                s.setStation_index(object.getInt("station_index"));
                stationRepository.saveAndFlush(s);
                index++;
                if(index%20==0) System.out.println("存入了20条数据......");
            }
        }
        System.out.println("我是分割线********信息推送本地数据库成功！******");
        System.out.println("获取并存入了 "+index+" 条数据！");
        return jsonstr;
    }

    /**获取驾驶员信息并存入本地数据库*/
    @RequestMapping("/toGetDriverData")
    @ResponseBody
    public String getDriverData() throws UnsupportedEncodingException {

        String jsonstr = getData.getDriver();
        if(jsonstr == null){
            System.out.println("返回的数据是空的！~~~");
            return "json is empty!!!";
        }
        JSONObject jj = JSONObject.fromObject(jsonstr);
        String str1 = jj.toString();
       // String s = "张飞";
        String ss = new String(str1.getBytes("utf-8"),"ISO-8859-1");
        //@ResponseBody会自动使用"ISO-8859-1"来解码，所以要先用 "ISO-8859-1"编码一次，否则会乱码。
        System.out.println("我是分割线***********************");
        JSONObject jsonObject1 = (JSONObject)jj.get("Content");
        JSONArray jsonObject2 = (JSONArray)jsonObject1.get("Records");
        int index = 0;
        for(int i=0;i<jsonObject2.size();i++){
            JSONObject o = (JSONObject)jsonObject2.get(i);
            Integer busline_id = (Integer)o.get("busline_id");
            JSONArray array = o.getJSONArray("DriverModels");
            for(int j=0;j<array.size();j++){
                JSONObject oo = array.getJSONObject(j);
                Driver d = new Driver();
                d.setBusline_id(busline_id);
                d.setDriver_id(oo.getInt("driver_id"));
                d.setDriver_name(oo.getString("driver_name"));
                d.setDriver_no(oo.getString("driver_no"));
                d.setCard_no(oo.getString("card_no"));
                driverRepository.saveAndFlush(d);
                index++;
                if(index%20==0) System.out.println("存入了20条数据......");
            }
        }
        System.out.println("我是分割线********信息推送本地数据库成功！******");
        System.out.println("********总共保存了" + index + "！******");
        return ss;
    }

    /**获取公交线路信息并存入本地数据库*/
    //@RequestMapping("/toGetBusLineData")
    //@ResponseBody
    public String getBusLineData() {
        String jsonstr = getData.getBusLine();
        if(jsonstr == null){
            System.out.println("返回的数据是空的！~~~");
            return "json is empty!!!";
        }
        JSONObject br = JSONObject.fromObject(jsonstr);
        String str1 = br.getString("Content");
        JSONObject o = JSONObject.fromObject(str1);
        String str2 = o.getString("Records");
        JSONArray jsonArray = JSONArray.fromObject(str2);
       // System.out.println("我是分割线***********************");
        for (int i = 0; i < jsonArray.size(); i++) {
            Collection<BusLine> c  = JSONArray.toCollection(jsonArray,BusLine.class);
            for(BusLine b : c) {
                System.out.print(b);
                busLineRepository.saveAndFlush(b);
            }
        }
        //System.out.println("********我是分割线******数据插入成功！*******");
        return "successful!!!!!";

    }

    /**获取公交车信息并存入本地数据库*/
  //  @RequestMapping("/toGetBusData")
   // @ResponseBody
    public String getBusData(){
        String jsonstr = getData.getBus();
        if(jsonstr == null){
            System.out.println("返回的数据是空的！~~~");
            return "json is empty!!!";
        }
       JSONObject br = JSONObject.fromObject(jsonstr);
        String str1 = br.getString("Content");
        JSONObject o1 = JSONObject.fromObject(str1);
        String str2 = o1.getString("Records");
        JSONArray jsonArray = JSONArray.fromObject(str2);
        System.out.println("我是分割线***********************");
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = (JSONObject)jsonArray.get(i);
            Integer busline_id = (Integer)jsonObject.get("busline_id");
            JSONArray array = (JSONArray)jsonObject.get("CarModels");
            for(int j=0;j<array.size();j++)
            {
                JSONObject jsonObject1 = (JSONObject)array.get(j);
                Integer car_id = (Integer)jsonObject1.get("car_id");
                String car_no = (String) jsonObject1.get("car_no");
                String dev_id = (String) jsonObject1.get("dev_id");
                Bus bus = new Bus();
                bus.setBusline_id(busline_id);
                bus.setCar_id(car_id);
                bus.setCar_no(car_no);
                bus.setDev_id(dev_id);
                busRepostory.saveAndFlush(bus);
                System.out.println("我是分割线*******successful!*******");
            }
        }
        return str2;
    }
}
