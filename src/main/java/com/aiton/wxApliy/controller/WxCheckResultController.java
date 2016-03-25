package com.aiton.wxApliy.controller;

import com.aiton.wxApliy.dao.WxResultRepository;
import com.aiton.wxApliy.entity.WxPayResults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-25
 * Time: 上午8:45
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WxCheckResultController {
    @Resource
    private WxResultRepository wxResultRepository;
    @RequestMapping("/wx/wxcheck")
    @ResponseBody
    public Boolean execute(String out_trade_no){
        try{
            WxPayResults wxPayResults=wxResultRepository.findOne(out_trade_no);
            if(wxPayResults==null){
               return false;
            }else {
                return true;
            }
        }catch (Exception e){
            return false;
        }
    }
}
