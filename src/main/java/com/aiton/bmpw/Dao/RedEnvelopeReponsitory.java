package com.aiton.bmpw.dao;

import com.aiton.bmpw.entity.RedEnvelope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 上午10:31
 * To change this template use File | Settings | File Templates.
 */
public interface RedEnvelopeReponsitory extends JpaRepository<RedEnvelope,Integer> {
    /**
     * 查找所有没过期的红包
     * @return
     */
    @Query("from RedEnvelope where flag<>2 and status=0")
    List<RedEnvelope> findRedEnvelopeNotOverDue();

    /**
     * 查找可以配给用户的红包(票务)
     * @return
     */
    @Query("from RedEnvelope where flag=0 and user_id is null and status=0 and activity=?")
    List<RedEnvelope> findRedEnvelope(Integer activity);
    /**
     * 查找用户的红包
     */
    @Query("from RedEnvelope where user_id=?")
    List<RedEnvelope>findRedEnvelopeByUser_id(Integer user_id);
    @Query("from RedEnvelope where user_id=? and flag=0")
    List<RedEnvelope>findRedEnvelopeByUser_idCanBeUse(Integer user_id);
    @Query("select distinct max(r.activity) from RedEnvelope as r")
    Object findMaxAcitvity();
    @Query("select distinct r.activity from RedEnvelope as r where user_id=?")
    List<Object> findActivitiesByAccountID(Integer accountid);
    @Query("from RedEnvelope where user_id=:user_id and activity=:activity")
    RedEnvelope findByActivityAndUserID(@Param("user_id")Integer user_id,@Param("activity")Integer activity);
}
