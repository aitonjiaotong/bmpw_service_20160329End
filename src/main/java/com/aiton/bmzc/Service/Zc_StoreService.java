package com.aiton.bmzc.Service;

import com.aiton.bmzc.Entity.Zc_Store;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 上午10:08
 * To change this template use File | Settings | File Templates.
 */
public interface Zc_StoreService {
    Zc_Store addStore(Zc_Store store);
    Boolean delStore(Integer sotre_id);
    Zc_Contains_num loadCity(Integer page);
    Zc_Contains_num loadStore(String city,Integer page);
}
