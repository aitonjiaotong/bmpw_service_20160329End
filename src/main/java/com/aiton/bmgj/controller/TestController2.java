package com.aiton.bmgj.controller;

import com.aiton.bmgj.dao.*;
import com.aiton.bmgj.entity.*;
import com.aiton.bmgj.service.serviceUtil.GetChineseFirstLetter;
import com.aiton.bmgj.service.serviceUtil.GetData;
import com.aiton.bmgj.service.serviceUtil.PinyinUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;


/**
 * 获取数据Controller
 * Created by user on 2016/3/3.
 */
@Controller
public class TestController2 {

    @Resource
    private GetData getData;
    @Resource
    private GetChineseFirstLetter getChineseFirstLetter;

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
    private String alpha;

    /**测试用Controller*/
    @RequestMapping("/toTest")
    @ResponseBody
    public String getDataTest() throws UnsupportedEncodingException {
        String jsonstr = getData.getStationBase();
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
        int index = 0;
        int i;
        System.out.println("*********我是分割线********信息开始推送本地！******");
        for(i=0;i<jsonArray.size();i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            StationBase stationBase = new StationBase();
            stationBase.setStation_id(jsonObject.getInt("station_id"));
            stationBase.setLng(jsonObject.getInt("lng"));
            stationBase.setLat(jsonObject.getInt("lat"));
            String station_name = jsonObject.getString("station_name");
            //station_name = station_name.replaceAll("\\p{P}" , "");
            //System.out.println(station_name);
            alpha = PinyinUtils.getAlpha(station_name.replaceAll("\\p{P}" , ""));
            stationBase.setStation_name(station_name);
            stationBase.setChineseFirstLetter(alpha);
            StationBase s = stationBaseRepository.findStationBaseByStationIdAndStationName(stationBase.getStation_id(),station_name);
            if(s==null) {
                stationBaseRepository.saveAndFlush(stationBase);
                index++;
            }else{
                stationBase.setId(s.getId());
                stationBaseRepository.saveAndFlush(stationBase);
            }
            //if(index%20==0) System.out.println("已经存入20条数据.....");
        }
        System.out.println("*********我是分割线********信息推送本地数据库成功！******");
        System.out.println("存入了 " + index + " 条数据.....");
        System.out.println("总共获取了 " + i + " 条数据.....");
        return "successful!!!!";
    }

    /**获取站点信息并存入本地数据库*/
    //@RequestMapping("/toGetStationData")
    //@ResponseBody
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
                s.setBusline_id(busline_id);
                s.setStation_id(object.getInt("station_id"));
                s.setStation_index(object.getInt("station_index"));
                List<Station> list = stationRepository.
                        findStationByBusLineIdAndStationId
                                (s.getBusline_id(), s.getStation_id(), s.getUp_down());
                //System.out.println(list.size());
                if(list == null || list.size()==0){
                    stationRepository.saveAndFlush(s);
                    index++;
                }else if(list.size()>1){
                    System.out.println("出错啦！！出现了相同的线路站点对象！！");
                    return "error";
                }else{
                    Station station = list.get(0);
                    s.setId(station.getId());
                    stationRepository.saveAndFlush(s);
                }
                if(index%20==0) System.out.println("存入了20条数据......");
            }
        }
        System.out.println("我是分割线********信息推送本地数据库成功！******");
        System.out.println("此次新增数据" + index + "条......");
        return jsonstr;
    }

    /**获取驾驶员信息并存入本地数据库 已经存入成功*/
    //@RequestMapping("/toGetDriverData")
    //@ResponseBody
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
                Driver driver = driverRepository.findDriverByDriverId(d.getDriver_id());
                if(driver==null){
                    driverRepository.saveAndFlush(d);
                    index++;
                }else{
                    d.setId(driver.getId());
                    driverRepository.saveAndFlush(d);
                }
               // if(index%20==0 && index!=0) System.out.println("存入了20条数据......");
            }
        }
        System.out.println("我是分割线********信息推送本地数据库成功！******");
        System.out.println("此次新增数据" + index + "条......");
        return ss;
    }

    /**获取公交线路信息并存入本地数据库 已经存入成功*/
    @RequestMapping("/toGetBusLineData")
    @ResponseBody
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
        System.out.println("我是分割线***********************");
        int sum = 0;
        int index = 0;
        for (int i = 0; i < jsonArray.size(); i++) {
            Collection<BusLine> c  = JSONArray.toCollection(jsonArray,BusLine.class);
            for(BusLine b : c) {
                busLineRepository.saveAndFlush(b);
                index++;
                sum++;
                if(index%20==0) System.out.println("已存入20条数据......");
            }
        }
        System.out.println("********我是分割线******数据插入成功！*******");
        System.out.println("此次新增数据" + index + "条......");
        System.out.println("总共数据" + sum + "条......");
        return "successful!!!!!";

    }

    /**获取公交车信息并存入本地数据库 已经存入成功*/
    //@RequestMapping("/toGetBusData")
    //@ResponseBody
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
        int index = 0;
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
                Bus b = busRepostory.findBusByCarId(car_id);
                if(b == null) {
                    busRepostory.saveAndFlush(bus);
                    index ++ ;
                }else{
                    bus.setId(b.getId());
                    busRepostory.saveAndFlush(bus);
                }
            }
        }
        System.out.println("我是分割线*******successful!*******");
        System.out.println("此次新增数据" + index + "条......");
        return str2;
    }
}
