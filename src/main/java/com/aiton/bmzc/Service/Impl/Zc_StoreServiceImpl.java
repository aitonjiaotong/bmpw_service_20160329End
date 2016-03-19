package com.aiton.bmzc.Service.Impl;

import com.aiton.bmzc.Dao.zc_StoreRepository;
import com.aiton.bmzc.Entity.Zc_Store;
import com.aiton.bmzc.Service.Zc_StoreService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 上午10:09
 * To change this template use File | Settings | File Templates.
 */
@Service
public class Zc_StoreServiceImpl implements Zc_StoreService {
    @Resource
    private zc_StoreRepository storeRepository;
    @Override
    public Zc_Store addStore(Zc_Store store) {
        Zc_Store store1=storeRepository.saveAndFlush(store);
        return store1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean delStore(Integer sotre_id) {
        try {
            storeRepository.delete(sotre_id);
            return true;
        }catch (Exception e){
            return false;
        }
          //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Object> loadCity(Integer page) {
        List<Object>cities=storeRepository.loadCity(new PageRequest(page,8));
        return cities;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
