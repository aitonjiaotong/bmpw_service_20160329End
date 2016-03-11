package com.aiton.bmgj.dao;

import com.aiton.bmgj.entity.BusLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by user on 2016/3/3.
 */
public interface BusLineRepository extends JpaRepository<BusLine,Integer> {
    @Query("from BusLine where busline_no = ?")
    BusLine findBusLineByNO(Integer busline_no);
}
