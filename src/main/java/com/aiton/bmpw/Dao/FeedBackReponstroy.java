package com.aiton.bmpw.dao;

import com.aiton.bmpw.entity.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-24
 * Time: 上午9:24
 * To change this template use File | Settings | File Templates.
 */
public interface FeedBackReponstroy extends JpaRepository<FeedBack,Integer>{
    @Query("select f from FeedBack as f where f.phone like :phone")
    Page<FeedBack> findFeedBackByPhoneLike(@Param("phone")String phone,Pageable pageable);
    @Query("select count(f) from FeedBack as f where f.phone like ?")
    Object countFeedBackByPhoneLike(String phone);
}
