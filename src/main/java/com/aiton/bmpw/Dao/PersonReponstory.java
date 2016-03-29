package com.aiton.bmpw.dao;

import com.aiton.bmpw.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-5
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
public interface PersonReponstory extends JpaRepository<Person,Integer> {
    @Query("from Person where account_id=?")
    List<Person> findByAccount_id(Integer account_id);
    @Query("from Person where account_id=:account_id and idcard=:idcard")
    Person findByAccountAndID(@Param("account_id")Integer account_id,@Param("idcard")String idcard);
}
