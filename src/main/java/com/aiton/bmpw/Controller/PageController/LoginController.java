package com.aiton.bmpw.controller.pageController;

import com.aiton.bmpw.util.bmpwUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午3:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String execute(String code,String password){
        String result="";
        String p= bmpwUtils.StringMD5(password);
        UsernamePasswordToken token=new UsernamePasswordToken(code,p);
//        System.out.println(code);
//        System.out.println(password);
        Subject currectUser= SecurityUtils.getSubject();
        try{
            //判断是否为已通过验证用户,如果不是，记住并验证
            if(!currectUser.isAuthenticated()){
                //记住我
                token.setRememberMe(true);
                //验证
                currectUser.login(token);
            }
            //验证通过
            result="redirect:/home";
        }catch(Exception e){
            //验证不通过
            result="redirect:/toLogin";
        }
        return result;
    }
}
