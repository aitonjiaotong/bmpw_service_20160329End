package com.aiton.bmpw.service;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.entity.RedEnvelope;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 下午2:29
 * To change this template use File | Settings | File Templates.
 */
public interface RedEnvelopeService {
    void addRedEnvelope(Integer sum,Date validity,Double max,Double min,Integer status);
    void setRedEnvelopeOverdue();
    RedEnvelope getRedEnvelope(Integer user_id,Integer activity);
    List<RedEnvelope>getUserRedEnvelope(Integer user_id);
    DataTables loadAllRedEnvelope(Integer draw,Integer start,Integer length,HttpServletRequest request);
    Integer delRedEnvelope(Integer id);
    Integer getNumOfRedEnvelope(Integer account_id);
}
