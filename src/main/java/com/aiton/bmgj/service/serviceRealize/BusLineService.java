package com.aiton.bmgj.service.serviceRealize;

import com.aiton.bmgj.dao.BusLineRepository;
import com.aiton.bmgj.entity.BusLine;
import com.aiton.bmgj.service.serviceImpl.BusLineServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by user on 2016/3/7.
 */
@Service
public class BusLineService implements BusLineServiceImpl{
    @Resource
    private BusLineRepository busLineRepository;

    public BusLineService() {
        super();
    }

    @Override
    public BusLine findBusLineById(Integer id) {
        return null;
    }

    @Override
    public List<BusLine> findBusLineAll() {
        return null;
    }

    @Override
    public BusLine findBusLineByNo(Integer no) {
        BusLine busLine = busLineRepository.findBusLineByNO(no);
        return busLine;
    }
}
