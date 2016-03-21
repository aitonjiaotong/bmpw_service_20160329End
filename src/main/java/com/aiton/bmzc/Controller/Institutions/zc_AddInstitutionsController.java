package com.aiton.bmzc.Controller.Institutions;

import com.aiton.bmzc.Entity.zc_Institutions;
import com.aiton.bmzc.Service.zc_InstitutionsService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 下午4:05
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class zc_AddInstitutionsController {
    @Resource
    private zc_InstitutionsService institutionsService;
    @RequestMapping("/zc/institutions/addinstitutions")
    @ResponseBody
    public zc_Institutions execute(zc_Institutions institutions){
        institutions=institutionsService.addInstitutions(institutions);
        return institutions;
    }
}
