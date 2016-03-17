package com.aiton.bmpw.Controller.ModelController.Refund;

import com.aiton.bmpw.Entity.Pw_Refund;
import com.aiton.bmpw.Service.pw_RefundService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class pw_UpdateRefundController {
    @Resource
    private pw_RefundService refundService;
    @RequestMapping("/refund/updaterefund")
    @ResponseBody
    public Pw_Refund execute(String bookLogAID){
        Pw_Refund refund=refundService.updateRedfund(bookLogAID);
        return refund;
    }
}
