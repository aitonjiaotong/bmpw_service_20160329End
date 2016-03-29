package com.aiton.bmzc.service;

import com.aiton.bmzc.entity.ZcInstitutions;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
public interface ZcInstitutionsService {
    ZcInstitutions addInstitutions(ZcInstitutions institutions);
    ZcInstitutions updateInstitutions(ZcInstitutions institutions);
    Boolean check(String code,String password);
    ZcInstitutions loadInstitutions(String code);
}
