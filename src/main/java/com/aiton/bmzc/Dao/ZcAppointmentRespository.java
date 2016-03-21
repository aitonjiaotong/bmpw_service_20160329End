package com.aiton.bmzc.Dao;

import com.aiton.bmzc.Entity.ZcAppointment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 下午4:32
 * To change this template use File | Settings | File Templates.
 */
public interface ZcAppointmentRespository extends JpaRepository<ZcAppointment,Integer> {
    @Query("from ZcAppointment where user like ?")
    List<ZcAppointment> findByNameLike(String user,Pageable pageable);
    @Query("select count(a) from ZcAppointment as a where user like ?")
    Object CountByNameLike(String user);
}
