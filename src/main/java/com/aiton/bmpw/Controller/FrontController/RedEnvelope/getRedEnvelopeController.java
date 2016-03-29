package com.aiton.bmpw.controller.frontController.RedEnvelope;

import com.aiton.bmpw.entity.RedEnvelope;
import com.aiton.bmpw.service.RedEnvelopeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-25
 * Time: 上午9:25
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class getRedEnvelopeController {
    @Resource
    private RedEnvelopeService service;
    @RequestMapping("/front/getRedEnvelope")
    @ResponseBody
    public synchronized RedEnvelope execute(Integer account_id,Integer activity){
        RedEnvelope redEnvelope=service.getRedEnvelope(account_id,activity);
        return redEnvelope;
    }
}
