package com.aiton.bmzc.Controller.Institutions;

import com.aiton.bmzc.Entity.zc_Institutions;
import com.aiton.bmzc.Service.zc_InstitutionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class zc_CheckInstitutionsController {
    @Resource
    private zc_InstitutionsService institutionsService;
    @RequestMapping("/zc/institutions/checkinstitutions")
    @ResponseBody
    public Boolean execute(String code,String password){
        Boolean flag=institutionsService.check(code,password);
        return flag;
    }
}
