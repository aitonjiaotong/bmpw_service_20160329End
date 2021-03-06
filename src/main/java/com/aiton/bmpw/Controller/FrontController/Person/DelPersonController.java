package com.aiton.bmpw.controller.frontController.Person;

import com.aiton.bmpw.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 上午9:08
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class DelPersonController {
    @Resource
    private PersonService personService;
    @RequestMapping("/person/delperson")
    @ResponseBody
    public Boolean execute(Integer person_id){
        Boolean flag=personService.delPerson(person_id);
        return flag;
    }
}
