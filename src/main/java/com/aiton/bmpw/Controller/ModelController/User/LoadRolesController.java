package com.aiton.bmpw.controller.modelController.User;

import com.aiton.bmpw.entity.model.Role;
import com.aiton.bmpw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-1
 * Time: 上午10:36
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoadRolesController {
    @Resource
    private UserService userService;
    @RequestMapping("/model/loadroles")
    @ResponseBody
    public List<Role> execute(){
        List<Role> roles=userService.loadRoles();
        return roles;
    }
}
