package com.aiton.bmpw.controller.frontController.RedEnvelope;

import com.aiton.bmpw.service.RedEnvelopeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-2
 * Time: 下午2:53
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GetNumOfRedEnvelopeController {
    @Resource
    private RedEnvelopeService redEnvelopeService;
    @RequestMapping("/redenvelope/getnumofredenvelopebyuser")
    @ResponseBody
    public Integer execute(Integer account_id){
         Integer a=redEnvelopeService.getNumOfRedEnvelope(account_id);
        return a;
    }
}
