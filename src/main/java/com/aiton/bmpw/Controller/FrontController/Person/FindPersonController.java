package com.aiton.bmpw.Controller.FrontController.Person;

import com.aiton.bmpw.Entity.Person;
import com.aiton.bmpw.Service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 上午9:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class FindPersonController {
    @Resource
    private PersonService personService;
    @RequestMapping("/person/findperson")
    @ResponseBody
    public List<Person> execute(Integer account_id){
         List<Person>list=personService.findPerson(account_id);
        return list;
    }
}
