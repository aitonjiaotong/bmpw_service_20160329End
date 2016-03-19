package com.aiton.bmzc.Controller.Store;

import com.aiton.bmzc.Entity.Zc_Store;
import com.aiton.bmzc.Service.Zc_StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 上午9:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class zc_LoadStoreController {
    @Resource
    private Zc_StoreService storeService;
    @RequestMapping("/zc/store/loadstorebycity")
    @ResponseBody
    public List<Zc_Store> execute(String city){
        List<Zc_Store>stores=storeService.loadStore(city);
        return stores;
    }
}
