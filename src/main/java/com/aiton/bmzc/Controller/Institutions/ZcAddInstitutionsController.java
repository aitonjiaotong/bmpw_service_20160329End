package com.aiton.bmzc.Controller.Institutions;

import com.aiton.bmzc.Entity.ZcInstitutions;
import com.aiton.bmzc.Service.ZcInstitutionsService;
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
public class ZcAddInstitutionsController {
    @Resource
    private ZcInstitutionsService institutionsService;
    @RequestMapping("/zc/institutions/addinstitutions")
    @ResponseBody
    public ZcInstitutions execute(ZcInstitutions institutions){
        institutions=institutionsService.addInstitutions(institutions);
        return institutions;
    }
}
