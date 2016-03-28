package com.aiton.bmzc.controller.Store;

import com.aiton.bmzc.Entity.ZcContainsNum;
import com.aiton.bmzc.Service.ZcStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 上午9:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ZcLoadStoreController {
    @Resource
    private ZcStoreService storeService;
    @RequestMapping("/zc/store/loadstorebycity")
    @ResponseBody
    public ZcContainsNum execute(String city,Integer page){
        ZcContainsNum stores=storeService.loadStore(city,page);
        return stores;
    }
}
