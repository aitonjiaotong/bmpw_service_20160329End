package com.aiton.bmzc.Service.Impl;

import com.aiton.bmpw.Util.bmpwUtils;
import com.aiton.bmzc.Dao.zc_InstitutionsRepository;
import com.aiton.bmzc.Entity.zc_Institutions;
import com.aiton.bmzc.Service.zc_InstitutionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-18
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
@Service
public class zc_InstitutionsServiceImpl implements zc_InstitutionsService {
    @Resource
    private zc_InstitutionsRepository institutionsRepository;
    @Override
    public zc_Institutions addInstitutions(zc_Institutions institutions) {
        Long time=System.currentTimeMillis();
        institutions.setCode(time.toString());
        String password=institutions.getPassword();
        password= bmpwUtils.StringMD5(password);
        institutions.setPassword(password);
        institutions=institutionsRepository.saveAndFlush(institutions);
        return institutions;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public zc_Institutions updateInstitutions(zc_Institutions institutions) {
        institutions=institutionsRepository.saveAndFlush(institutions);
        return institutions;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean check(String code, String password) {
        if(password==null||"".equals(password)){
            return false;
        }
        password=bmpwUtils.StringMD5(password);
        try{
            zc_Institutions institutions=institutionsRepository.findOne(code);
            if(institutions==null){
                return false;
            }
            if(password.equals(institutions.getPassword())){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public zc_Institutions loadInstitutions(String code) {
        zc_Institutions zc_institutions = institutionsRepository.findOne(code);
        return null;
    }
}
