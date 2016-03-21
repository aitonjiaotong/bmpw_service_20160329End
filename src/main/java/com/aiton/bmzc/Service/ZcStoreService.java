package com.aiton.bmzc.Service;

import com.aiton.bmzc.Entity.ZcContainsNum;
import com.aiton.bmzc.Entity.ZcStore;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 上午10:08
 * To change this template use File | Settings | File Templates.
 */
public interface ZcStoreService {
    ZcStore addStore(ZcStore store);
    Boolean delStore(Integer sotre_id);
    ZcContainsNum loadCity(Integer page);
    ZcContainsNum loadStore(String city,Integer page);
}
