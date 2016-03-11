package com.aiton.bmgj.service.serviceRealize;

import com.aiton.bmgj.dao.StationRepository;
import com.aiton.bmgj.entity.LastGpsData;
import com.aiton.bmgj.service.serviceImpl.LastGpsDataServiceImpl;
import com.aiton.bmgj.service.serviceUtil.GetData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 2016/3/10.
 */
@Scope(value = "request")
@Service
public class LastGpsDataService implements LastGpsDataServiceImpl {

    @Resource
    private GetData getData;
    private StationRepository stationRepository;

    private List<LastGpsData> lastGpsDatas;


    @Override
    public List<LastGpsData> findLastGpsDatasByBusLine(Integer busLineId,Integer up_down) {
        findLastGpsDataAll_now();
        List<LastGpsData> list = new ArrayList<LastGpsData>();
        for(LastGpsData lastGpsData : lastGpsDatas){
            if(lastGpsData.getBusline_id() == busLineId){
               list.add(lastGpsData);
            }
        }
        return list;
    }

    @Override
    public LastGpsData findLastGpsDataByBusId(Integer busId) {

        return null;
    }


    private void findLastGpsDataAll_now() {
        try {
            String jsonstr = getData.getLastGpsData();
            JSONArray array = JSONObject.fromObject(jsonstr)
                    .getJSONObject("Content").getJSONArray("Records");
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Integer busline_id = jsonObject.getInt("busline_id");
                JSONArray jsonArray = jsonObject.getJSONArray("LastGpsDataModels");
                for (int j = 0; j < jsonArray.size(); j++) {
                    JSONObject object = jsonArray.getJSONObject(j);
                    Integer car_id = object.getInt("car_id");
                    String car_no = object.getString("car_no");
                    //2016/3/10 10:49:14
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = sdf.parse(object.getString("gps_time"));
                    Integer lng = object.getInt("lng");
                    Integer lat = object.getInt("lat");
                    Integer hight = object.getInt("hight");
                    Integer speed = object.getInt("speed");
                    Integer direct = object.getInt("direct");
                    LastGpsData lastGpsData = new LastGpsData
                            (busline_id,car_id,car_no,date,
                                    lng,lat,hight,speed,direct);
                    lastGpsDatas = new ArrayList<LastGpsData>();
                    lastGpsDatas.add(lastGpsData);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public JSONObject findLastGpsDatasByStationId(Integer stationId) {
        List<Integer> busline_ids = stationRepository.findBusLineIdByStationId(stationId);
        JSONObject object = new JSONObject();
        for(Integer busline_id : busline_ids) {
            List<LastGpsData> gpsDatas = findLastGpsDatasByBusLine(busline_id,null);
            object.put(busline_id,gpsDatas);
        }
        return object;
    }
}
