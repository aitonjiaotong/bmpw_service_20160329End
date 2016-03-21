package com.aiton.bmzc.Service.Impl;

import com.aiton.bmpw.Util.bmpwUtils;
import com.aiton.bmzc.Dao.zc_InstitutionsRepository;
import com.aiton.bmzc.Entity.ZcInstitutions;
import com.aiton.bmzc.Service.ZcInstitutionsService;
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
public class ZcInstitutionsServiceImpl implements ZcInstitutionsService {
    @Resource
    private zc_InstitutionsRepository institutionsRepository;
    @Override
    public ZcInstitutions addInstitutions(ZcInstitutions institutions) {
        Long time=System.currentTimeMillis();
        institutions.setCode(time.toString());
        String password=institutions.getPassword();
        password= bmpwUtils.StringMD5(password);
        institutions.setPassword(password);
        institutions=institutionsRepository.saveAndFlush(institutions);
        return institutions;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ZcInstitutions updateInstitutions(ZcInstitutions institutions) {
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
            ZcInstitutions institutions=institutionsRepository.findOne(code);
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
    public ZcInstitutions loadInstitutions(String code) {
        ZcInstitutions zc_institutions = institutionsRepository.findOne(code);
        return null;
    }
}
