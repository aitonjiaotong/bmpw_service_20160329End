package com.aiton.bmzc.service.impl;

import com.aiton.bmzc.dao.ZcStoreRepository;
import com.aiton.bmzc.entity.ZcContainsNum;
import com.aiton.bmzc.entity.ZcStore;
import com.aiton.bmzc.service.ZcStoreService;
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
public class ZcStoreServiceImpl implements ZcStoreService {
    @Resource
    private ZcStoreRepository storeRepository;
    @Override
    public ZcStore addStore(ZcStore store) {
        ZcStore store1=storeRepository.saveAndFlush(store);
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
    public ZcContainsNum loadCity(Integer page) {
        List<Object>cities=storeRepository.loadCity(new PageRequest(page,8));
        List<Object>s=storeRepository.countCity();
        ZcContainsNum contains_num=new ZcContainsNum();
        contains_num.setContains(cities);
        System.out.println(s.size());
        Integer pageAll=(int)Math.ceil((double)s.size()/8);
        contains_num.setNum(pageAll);
        return contains_num;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ZcContainsNum loadStore(String city,Integer page) {
        ZcContainsNum contains_num=new ZcContainsNum();
        List<ZcStore>stores=storeRepository.loadStore(city,new PageRequest(page,8));
        Object s=storeRepository.countStore(city);
        contains_num.setNum((int)Math.ceil(Double.valueOf(s.toString())/8));
        contains_num.setContains(stores);
        return contains_num;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
