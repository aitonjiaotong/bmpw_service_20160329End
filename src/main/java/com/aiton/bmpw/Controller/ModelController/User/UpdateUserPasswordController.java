package com.aiton.bmpw.controller.modelController.User;

import com.aiton.bmpw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-23
 * Time: 下午5:37
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class UpdateUserPasswordController {
    @Resource
    private UserService service;
    @RequestMapping("/users/updatepassword")
    @ResponseBody
    /**
     * password1为旧密码 password2为新密码
     * 返回值为状态。0为成功，1密码错误，2该用户不存在
     */
    public Integer execute(String code,String password1,String password2){
        Integer status=service.updateUserPassword(code,password1,password2);
        return status;
    }
}
