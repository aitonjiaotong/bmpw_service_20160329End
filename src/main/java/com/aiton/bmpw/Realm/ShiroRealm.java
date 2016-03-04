package com.aiton.bmpw.Realm;

import com.aiton.bmpw.Entity.Model.User;
import com.aiton.bmpw.Service.RealmService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 上午9:08
 * To change this template use File | Settings | File Templates.
 */
public class ShiroRealm extends AuthorizingRealm {
    @Resource
    private RealmService service;
    /**
     * 获取权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username= (String) principalCollection.fromRealm(getName()).iterator().next();
        if(username!=null){
            List<String> urls=service.getUrlsByCode(username);
            if(urls!=null && !urls.isEmpty()){
                SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
                //将权限资源添加进用户信息
                info.addStringPermissions(urls);
                return  info;
            }
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 登陆调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        String username=usernamePasswordToken.getUsername();
        if(username!=null && !"".equals(username)){
            User user=service.getUserByCode(username);
            //System.out.println(user);
            if(user !=null){
                SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user.getUser_code(),user.getUser_password(),getName());
                return  info;
            }
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
