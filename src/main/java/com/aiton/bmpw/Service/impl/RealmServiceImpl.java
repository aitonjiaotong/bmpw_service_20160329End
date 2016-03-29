package com.aiton.bmpw.service.impl;

import com.aiton.bmpw.dao.PermissionReponstory;
import com.aiton.bmpw.dao.RolePermissionReponstory;
import com.aiton.bmpw.dao.UserReponstory;
import com.aiton.bmpw.dao.UserRoleReponstory;
import com.aiton.bmpw.entity.model.Permission;
import com.aiton.bmpw.entity.model.Role_Permission;
import com.aiton.bmpw.entity.model.User;
import com.aiton.bmpw.entity.model.User_Role;
import com.aiton.bmpw.service.RealmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午2:03
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RealmServiceImpl implements RealmService{
    /**
     *根据用户名获取用户权限
     * @param code
     * @return 权限url
     */
    @Resource
    private UserReponstory userReponstory;
    @Resource
    private UserRoleReponstory userRoleReponstory;
    @Resource
    private RolePermissionReponstory rolePermissionReponstory;
    @Resource
    private PermissionReponstory permissionReponstory;
    @Override
    public List<String> getUrlsByCode(String code) {
        List<String>urls=new ArrayList<String>();
        User user=userReponstory.findByCode(code);
        User_Role user_role=userRoleReponstory.findByUserId(user.getId());
        List<Role_Permission>role_permissions=rolePermissionReponstory.findByRoleId(user_role.getRole_id());
        for(Role_Permission role_permission:role_permissions){
            Integer permission_id=role_permission.getPermission_id();
            Permission permission=permissionReponstory.findOne(permission_id);
            urls.add(permission.getUrl());
        }
        return urls;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getUserByCode(String code) {
        User user=userReponstory.findByCode(code);
        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
