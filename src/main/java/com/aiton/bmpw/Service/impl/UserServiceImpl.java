package com.aiton.bmpw.service.impl;

import com.aiton.bmpw.dao.RoleReponstory;
import com.aiton.bmpw.dao.UserReponstory;
import com.aiton.bmpw.dao.UserRoleReponstory;
import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.entity.model.Role;
import com.aiton.bmpw.entity.model.User;
import com.aiton.bmpw.entity.model.User_Role;
import com.aiton.bmpw.entity.show.User_Show;
import com.aiton.bmpw.service.UserService;
import com.aiton.bmpw.util.bmpwUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午4:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserReponstory userReponstory;
    @Resource
    private UserRoleReponstory userRoleReponstory;
    @Resource
    private RoleReponstory roleReponstory;
    @Override
    public Boolean AddUser(String code, String password,Integer role_id) {
        User user=userReponstory.findByCode(code);
        if(user==null){
            user=new User();
            user.setUser_code(code);
            user.setUser_password(bmpwUtils.StringMD5(password));
            user=userReponstory.saveAndFlush(user);
            Integer user_id=user.getId();
            User_Role user_role=new User_Role();
            user_role.setUser_id(user_id);
            user_role.setRole_id(role_id);
            userRoleReponstory.saveAndFlush(user_role);
            return true;
        }else{
            return false;
        }
         //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Role> loadRoles() {
        List<Role>roles=roleReponstory.findAll();
        return roles;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DataTables findAllUsers(Integer draw, Integer start, Integer length,HttpServletRequest request) {
        DataTables dataTables=new DataTables();
        Integer page=start/length;
//        System.out.println(draw);
//        System.out.println(page);
//        System.out.println(length);
        List<User>users=new ArrayList<User>();
        String search=request.getParameter("search[value]");
//        System.out.println(search+"+");
        if(search.equals("")){
            users =userReponstory.findAll(new PageRequest(page,length)).getContent();
        }else {
            search="%"+search+"%";
            System.out.println(search);
            users=userReponstory.findByCode(search, new PageRequest(page, length)).getContent();
        }
//        System.out.println(users.size());
        List<User_Show>list=new ArrayList<User_Show>();
        for(User user:users){
            Integer user_id=user.getId();
            Integer role_id=userRoleReponstory.findByUserId(user_id).getRole_id();
            String role=roleReponstory.findOne(role_id).getRole_name();
            User_Show user_show=new User_Show();
            user_show.setCode(user.getUser_code());
            user_show.setRole(role);
//            System.out.println(user_show.getCode());
//            System.out.println(user_show.getRole());
            list.add(user_show);
        }
        dataTables.setDraw(draw);
        long count=userReponstory.count();
        dataTables.setRecordsTotal(count);
        dataTables.setRecordsFiltered((long)users.size());
        dataTables.setData(list);
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 删除用户
     * @param code
     * @return
     */
    @Override
    public User delUser(String code) {
        User user=userReponstory.findByCode(code);
        if(user==null){
           return null;
        }
        userReponstory.delete(user);
        User_Role userRole=userRoleReponstory.findByUserId(user.getId());
        userRoleReponstory.delete(userRole);
        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 修改密码
     * @param code
     * @param password1
     * @param password2
     * @return 状态码
     */
    @Override
    public Integer updateUserPassword(String code, String password1, String password2) {
        User user=userReponstory.findByCode(code);
        if(user==null){
            return 2;
        }
        String password_old=bmpwUtils.StringMD5(password1);
        if(!password_old.equals(user.getUser_password())){
            return 1;
        }
        String password_new=bmpwUtils.StringMD5(password2);
        user.setUser_password(password_new);
        userReponstory.saveAndFlush(user);
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 修改用户角色
     * @param code
     * @param role_id
     * @return
     */
    @Override
    public Integer updateUserRole(String code, Integer role_id) {
        User user=userReponstory.findByCode(code);
        if(user==null){
            return 1;
        }
        User_Role user_role=userRoleReponstory.findByUserId(user.getId());
        if(user_role==null){
            user_role=new User_Role();
            user_role.setUser_id(user.getId());
            user_role.setRole_id(role_id);
        }else{
            user_role.setRole_id(role_id);
        }
        userRoleReponstory.saveAndFlush(user_role);
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean findUserByCode(String code) {
        User user=userReponstory.findByCode(code);
        if(user==null){
            return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
