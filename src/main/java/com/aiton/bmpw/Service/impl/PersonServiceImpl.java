package com.aiton.bmpw.service.impl;

import com.aiton.bmpw.dao.PersonReponstory;
import com.aiton.bmpw.entity.Person;
import com.aiton.bmpw.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-5
 * Time: 下午5:35
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonReponstory personReponstory;
    @Override
    public Integer addPerson(Person person) {
        Person person1=personReponstory.findByAccountAndID(person.getAccount_id(),person.getIdcard());
        if(person1==null){
            personReponstory.saveAndFlush(person);
            return 0;
        }
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean delPerson(Integer person_id) {
        try{
            personReponstory.delete(person_id);
            return true;
        }
        catch (Exception e){
            return false;
        }//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Integer updatePerson(Person person) {
        Person person1=personReponstory.findByAccountAndID(person.getAccount_id(),person.getIdcard());
        if(person1==null){
            //身份证不重复
            personReponstory.saveAndFlush(person);
            return 0;
        }else{
           if(person.getId().equals(person1.getId())){
              personReponstory.saveAndFlush(person);
              return 0;
           }

        }
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Person> findPerson(Integer account_id) {
        List<Person> persons=personReponstory.findByAccount_id(account_id);
        return persons;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
