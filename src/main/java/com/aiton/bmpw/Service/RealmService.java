package com.aiton.bmpw.service;

import com.aiton.bmpw.entity.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-4
 * Time: 下午2:02
 * To change this template use File | Settings | File Templates.
 */
public interface RealmService {
    List<String> getUrlsByCode(String code);
    User getUserByCode(String code);
}
