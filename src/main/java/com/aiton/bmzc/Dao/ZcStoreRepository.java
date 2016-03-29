package com.aiton.bmzc.dao;

import com.aiton.bmzc.entity.ZcStore;
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
public interface ZcStoreRepository extends JpaRepository<ZcStore,Integer> {
    @Query("select distinct s.city from ZcStore as s")
    List<Object> loadCity(Pageable pageable);
    @Query(" select distinct s.city from ZcStore as s")
    List<Object> countCity();
    @Query("from ZcStore where city=?")
    List<ZcStore> loadStore(String city,Pageable pageable);
    @Query("select count(s) from ZcStore as s where city=?")
    Object countStore(String city);
}
