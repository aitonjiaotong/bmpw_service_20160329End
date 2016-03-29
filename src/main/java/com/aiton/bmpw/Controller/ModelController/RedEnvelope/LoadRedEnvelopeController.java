package com.aiton.bmpw.controller.modelController.RedEnvelope;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.service.RedEnvelopeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-23
 * Time: 下午1:32
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoadRedEnvelopeController {
    @Resource
    private RedEnvelopeService redEnvelopeService;
    @RequestMapping("/redEnvelope/loadRedEnvelopes")
    @ResponseBody
    public DataTables execute(Integer draw,Integer start,Integer length,HttpServletRequest request){
        DataTables dataTables=redEnvelopeService.loadAllRedEnvelope(draw,start,length,request);
        return dataTables;
    }
}
