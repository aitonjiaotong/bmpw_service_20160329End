package com.aiton.bmpw.Controller.ModelController.User;

import com.aiton.bmpw.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-1
 * Time: 上午11:56
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class FindUserByCodeController {
    @Resource
    private UserService userService;
    @RequestMapping("/user/findbycode")
    @ResponseBody
    public Boolean execute(String code){
        Boolean flag=userService.findUserByCode(code);
        return flag;
    }
}
