package com.aiton.bmpw.Dao;

import com.aiton.bmpw.Entity.Model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午2:25
 * To change this template use File | Settings | File Templates.
 */
public interface PermissionReponstory extends JpaRepository<Permission,Integer> {
}
