package com.aiton.bmzc.Service;

import com.aiton.bmzc.Entity.zc_Institutions;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
public interface zc_InstitutionsService {
    zc_Institutions addInstitutions(zc_Institutions institutions);
    zc_Institutions updateInstitutions(zc_Institutions institutions);
    Boolean check(String code,String password);
    zc_Institutions loadInstitutions(String code);
}
