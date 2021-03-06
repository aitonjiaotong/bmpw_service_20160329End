package com.aiton.bmzc.controller.Institutions;

import com.aiton.bmzc.entity.ZcInstitutions;
import com.aiton.bmzc.service.ZcInstitutionsService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 下午4:12
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class ZcUpdateInstitutionsController {
    @Resource
    private ZcInstitutionsService institutionsService;
    @RequestMapping("/zc/institutions/updateinstitutions")
    @ResponseBody
    public ZcInstitutions execute(ZcInstitutions institutions){
        institutions=institutionsService.updateInstitutions(institutions);
        return institutions;
    }
}
