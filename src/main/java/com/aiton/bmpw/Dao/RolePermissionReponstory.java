package com.aiton.bmpw.Dao;

import com.aiton.bmpw.Entity.Model.Role_Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
public interface RolePermissionReponstory extends JpaRepository<Role_Permission,Integer> {
    @Query("from Role_Permission where role_id=?")
    List<Role_Permission>findByRoleId(Integer roleId);
}
