package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.Zc_Store;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 上午10:16
 * To change this template use File | Settings | File Templates.
 */
public interface zc_StoreRepository extends JpaRepository<Zc_Store,Integer> {
    @Query("select distinct s.city from Zc_Store as s")
    List<Object> loadCity(Pageable pageable);
}
