package com.aiton.bmzc.controller.account;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmzc.service.ZcAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 下午3:34
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadAccountsController {
    @Resource
    private ZcAccountService accountService;
    @RequestMapping("/zc/account/loadaccounts")
    @ResponseBody
    public DataTables execute(Integer draw,Integer start,Integer length,HttpServletRequest request){
        DataTables dataTables=accountService.loadAccounts(draw,start,length,request);
        return dataTables;
    }
}
