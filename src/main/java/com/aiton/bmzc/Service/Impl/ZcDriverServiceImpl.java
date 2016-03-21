package com.aiton.bmzc.Service.Impl;

import com.aiton.bmzc.Dao.ZcDriverRepository;
import com.aiton.bmzc.Entity.ZcContainsNum;
import com.aiton.bmzc.Entity.ZcDriver;
import com.aiton.bmzc.Service.ZcDriverService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ZcDriverServiceImpl implements ZcDriverService {
    @Resource
    private ZcDriverRepository driverRepository;
    @Override
    public ZcContainsNum loadDriver(Integer page) {
        List<ZcDriver>drivers=driverRepository.loadFreeDriver(new PageRequest(page,8,new Sort(Sort.Direction.DESC,"star")));
        Integer num=1;
        Object o=driverRepository.countFreeDriver();
        if(o!=null){
            num=Integer.valueOf(o.toString());
        }
        ZcContainsNum containsNum=new ZcContainsNum();
        containsNum.setContains(drivers);
        containsNum.setNum(num);
        return containsNum;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
