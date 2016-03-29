package com.aiton.bmpw.dao;

import com.aiton.bmpw.entity.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-17
 * Time: 下午6:16
 * To change this template use File | Settings | File Templates.
 */
public interface ZoneReponsitory extends JpaRepository<Zone,Integer>{
    @Query("select z from Zone as z where z.zoneName like ?")
    Page<Zone> findZoneByName(String zoneName,Pageable pageable);
    @Query("from Zone where flag=1 or flag=2")
    List<Zone> getCanSetoutZone();
    @Query("from Zone where flag=0 or flag=2")
    List<Zone> getArriveZone();
    @Query("from Zone where fullCode like ?")
    List<Zone> getbylength(String s);
    @Query("from Zone where parentZoneID=?")
    List<Zone> getByParent(Integer parentZoneID);
}
