package com.aiton.bmpw.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Entity.Model.Role;
import com.aiton.bmpw.Entity.Model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 后台用户相关
 */
public interface UserService {
    Boolean AddUser(String code,String password,Integer role_id);
    List<Role> loadRoles();
    DataTables findAllUsers(Integer draw,Integer start,Integer length,HttpServletRequest request);
    User delUser(String code);
    Integer updateUserPassword(String code,String password1,String password2);
    Integer updateUserRole(String code,Integer role_id);
    Boolean findUserByCode(String code);
}
