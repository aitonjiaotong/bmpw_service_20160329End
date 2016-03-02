package com.aiton.bmpw.Dao;

import com.aiton.bmpw.Entity.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
public interface RoleReponstory extends JpaRepository<Role,Integer> {
}
