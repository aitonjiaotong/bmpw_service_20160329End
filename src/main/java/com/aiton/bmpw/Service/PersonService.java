package com.aiton.bmpw.Service;

import com.aiton.bmpw.Entity.Person;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-5
 * Time: 下午5:28
 * To change this template use File | Settings | File Templates.
 */
public interface PersonService {
    Integer addPerson(Person person);
    Boolean delPerson(Integer person_id);
    Integer updatePerson(Person person);
    List<Person> findPerson(Integer account_id);
}
