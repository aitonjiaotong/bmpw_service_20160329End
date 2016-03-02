package com.aiton.bmpw.Dao;

import com.aiton.bmpw.Entity.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午2:23
 * To change this template use File | Settings | File Templates.
 */
public interface UserReponstory extends JpaRepository<User,Integer>{
    @Query("from User where user_code=?")
    User findByCode(String code);
    @Query("select u from User as u where u.user_code like ?")
    Page<User> findByCode(String code,Pageable pageable);
}
