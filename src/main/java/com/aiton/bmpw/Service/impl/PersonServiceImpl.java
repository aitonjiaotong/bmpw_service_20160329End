package com.aiton.bmpw.Service.impl;

import com.aiton.bmpw.Dao.PersonReponstory;
import com.aiton.bmpw.Entity.Person;
import com.aiton.bmpw.Service.PersonService;
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
    public Person addPerson(Person person) {
        Person person1=personReponstory.saveAndFlush(person);
        return person1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean delPerson(Integer person_id) {
        personReponstory.delete(person_id);
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Person updatePerson(Person person) {
        Person person1=personReponstory.saveAndFlush(person);
        return person1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Person> findPerson(Integer account_id) {
        List<Person> persons=personReponstory.findByAccount_id(account_id);
        return persons;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
