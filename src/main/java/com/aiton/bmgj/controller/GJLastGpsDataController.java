package com.aiton.bmgj.controller;

import com.aiton.bmgj.entity.LastGpsData;
import com.aiton.bmgj.service.serviceUtil.GetData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by user on 2016/3/9.
 */
public class GJLastGpsDataController {
    @Resource
    private GetData getData;

    @RequestMapping("/getLastGpsData")
    @ResponseBody
    public List<LastGpsData> getLastGpsData(){
        String strjson = getData.getLastGpsData();
       // List<LastGpsData> list = getData.getLastGpsData();
        return null;
    }
}
