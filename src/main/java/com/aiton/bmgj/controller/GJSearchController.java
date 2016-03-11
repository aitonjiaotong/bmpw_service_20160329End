package com.aiton.bmgj.controller;

import com.aiton.bmgj.dao.StationBaseRepository;
import com.aiton.bmgj.entity.StationBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 索搜Controller
 * Created by user on 2016/3/9.
 */
@Controller
public class GJSearchController {
    @Resource
    private StationBaseRepository stationBaseRepository;

    /**
     * 用首字母搜索站点
     */
    @RequestMapping("/searchStationBaseByLetter")
    @ResponseBody
    public List<StationBase> findStationBaseByLetter(String letter){
        String s = "%" + letter + "%";
        List<StationBase> list = stationBaseRepository.findStationBaseByLetter(s);
        return list;
    }

    /**
     * 用中文汉字索搜站点
     * */
    @RequestMapping("/searchStationBaseByName")
    @ResponseBody
     public List<StationBase> findStationBaseByName(HttpServletRequest req) throws UnsupportedEncodingException {
        //req.setCharacterEncoding("iso-8859-1");
        String name = req.getParameter("name");
        String n = new String (name.getBytes("iso-8859-1"),"utf-8");
        System.out.println(n);
         n = "%" + n + "%";
        List<StationBase> list = stationBaseRepository.findStationBaseByName(n);
        return list;
    }
}
