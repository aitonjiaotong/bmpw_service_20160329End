package com.aiton.bmpw.controller.modelController.RedEnvelope;

import com.aiton.bmpw.service.RedEnvelopeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-23
 * Time: 下午3:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class DelRedEnvelopeController {
    @Resource
    private RedEnvelopeService service;
    @RequestMapping("/model/delRedEnvelope")
    @ResponseBody
    public Integer execute(Integer id){
        Integer status=service.delRedEnvelope(id);
        return status;
    }
}
