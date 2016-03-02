package com.aiton.bmpw.Controller.FrontController.RedEnvelope;

import com.aiton.bmpw.Entity.RedEnvelope;
import com.aiton.bmpw.Service.RedEnvelopeService;
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
