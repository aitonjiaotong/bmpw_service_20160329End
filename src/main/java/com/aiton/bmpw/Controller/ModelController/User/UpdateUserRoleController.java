package com.aiton.bmpw.Controller.ModelController.User;

import com.aiton.bmpw.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-23
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class UpdateUserRoleController {
    @Resource
    private UserService service;
    @RequestMapping("/user/updateUserRole")
    public Integer execute(String code,Integer role_id){
         Integer status=service.updateUserRole(code,role_id);
        return status;
    }
}
