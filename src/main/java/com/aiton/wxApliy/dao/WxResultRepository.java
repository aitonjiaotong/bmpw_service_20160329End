package com.aiton.wxApliy.dao;

import com.aiton.wxApliy.entity.WxPayResults;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-24
 * Time: 下午3:31
 * To change this template use File | Settings | File Templates.
 */
public interface WxResultRepository extends JpaRepository<WxPayResults,String> {
}
