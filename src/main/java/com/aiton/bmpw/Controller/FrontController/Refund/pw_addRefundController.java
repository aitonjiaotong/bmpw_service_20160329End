package com.aiton.bmpw.controller.frontController.Refund;

import com.aiton.bmpw.entity.Pw_Refund;
import com.aiton.bmpw.service.pw_RefundService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午9:40
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class pw_addRefundController {
    @Resource
    private pw_RefundService refundService;
    @RequestMapping("/front/addrefund")
    @ResponseBody
    public Pw_Refund execute(Pw_Refund refund){
        refund=refundService.addRedfund(refund);
        return refund;
    }
}
