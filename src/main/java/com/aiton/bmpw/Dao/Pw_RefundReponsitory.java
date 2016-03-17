package com.aiton.bmpw.Dao;

import com.aiton.bmpw.Entity.Pw_Refund;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午8:46
 * To change this template use File | Settings | File Templates.
 */
public interface Pw_RefundReponsitory extends JpaRepository<Pw_Refund,String>{
    @Query("select r from Pw_Refund r where r.phone like ? order by r.flag desc,r.clsj desc")
    Page<Pw_Refund> findByphone(String phone,Pageable pageable);
    @Query("select count(r) from Pw_Refund as r where r.phone like ?")
    Object CountByPhone(String phone);
}
