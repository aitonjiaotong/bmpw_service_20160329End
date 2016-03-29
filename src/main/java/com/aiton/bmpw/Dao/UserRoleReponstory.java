package com.aiton.bmpw.dao;

import com.aiton.bmpw.entity.model.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午2:26
 * To change this template use File | Settings | File Templates.
 */
public interface UserRoleReponstory extends JpaRepository<User_Role,Integer> {
    @Query("from User_Role where user_id=?")
    User_Role findByUserId(Integer userId);
}
