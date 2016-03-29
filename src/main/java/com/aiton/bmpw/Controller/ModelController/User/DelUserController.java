package com.aiton.bmpw.controller.modelController.User;

import com.aiton.bmpw.entity.model.User;
import com.aiton.bmpw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-19
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class DelUserController {
    @Resource
    private UserService userService;
    @RequestMapping("/model/deluser")
    @ResponseBody
    public User execute(String code){
        User user=userService.delUser(code);
        return user;
    }
}
