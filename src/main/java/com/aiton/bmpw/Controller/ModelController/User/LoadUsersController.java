package com.aiton.bmpw.controller.modelController.User;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 下午4:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoadUsersController {
    @Resource
    private UserService userService;
    @RequestMapping("/users/loadusers")
    @ResponseBody
    public DataTables execute(Integer draw, Integer start, Integer length,HttpServletRequest request){
        DataTables dataTables=userService.findAllUsers(draw,start,length,request);
//        Integer page=start/length;
//        String str=request.getParameter("search[value]");
//        System.out.println(str);

        return dataTables;
    }
}
