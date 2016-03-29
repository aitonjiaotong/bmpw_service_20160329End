package com.aiton.bmpw.controller.frontController.RedEnvelope;

import com.aiton.bmpw.entity.RedEnvelope;
import com.aiton.bmpw.service.RedEnvelopeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 下午3:07
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class getRedEnvelopeByUserController {
    @Resource
    private RedEnvelopeService redEnvelopeService;
    @RequestMapping("/redenvelope/getredenvelopebyuser")
    @ResponseBody
    public List<RedEnvelope>execute(Integer account_id){
         List<RedEnvelope>redEnvelopes=redEnvelopeService.getUserRedEnvelope(account_id);
        return redEnvelopes;
    }
}
