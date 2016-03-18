package com.aiton.bmpw.Controller.ModelController.Refund;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Service.pw_RefundService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午9:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class pw_loadRefundsController {
    @Resource
    private pw_RefundService refundService;
    @RequestMapping("/refund/loadrefunds")
    @ResponseBody
    public DataTables execute(Integer draw,Integer start,Integer length,HttpServletRequest request){
        DataTables dataTables=refundService.loadRefunds(draw,start,length,request);
        return dataTables;
    }
}
