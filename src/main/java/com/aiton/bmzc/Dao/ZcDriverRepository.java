package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.ZcDriver;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-9
 * Time: 下午3:49
 * To change this template use File | Settings | File Templates.
 */
public interface ZcDriverRepository extends JpaRepository<ZcDriver,Integer>{
    @Query("select d from ZcDriver as d where status=1")
    List<ZcDriver> loadFreeDriver(Pageable pageable);
    @Query("select count(d) from ZcDriver as d where status=1")
    Object countFreeDriver();
}
