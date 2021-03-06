package com.aiton.bmpw.controller.frontController.Person;

import com.aiton.bmpw.entity.Person;
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
 * Time: 上午9:12
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class UpdatePersonController {
    @Resource
    private PersonService personService;
    @RequestMapping("/person/updateperson")
    @ResponseBody
    public Integer execute(Person person){
        Integer flag=personService.updatePerson(person);
        return flag;
    }
}
