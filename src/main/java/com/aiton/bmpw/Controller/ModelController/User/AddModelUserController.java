package com.aiton.bmpw.Controller.ModelController.User;

import com.aiton.bmpw.Entity.Model.User;
import com.aiton.bmpw.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-16
 * Time: 上午8:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class AddModelUserController {
    @Resource
    private UserService userService;
    @RequestMapping("/model/adduser")
    @ResponseBody
    public Boolean execute(String code,String password,Integer role_id){
        Boolean flag=userService.AddUser(code,password,role_id);
        return flag;
    }
}
