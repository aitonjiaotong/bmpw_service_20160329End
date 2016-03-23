package com.aiton.weixinapliy;

import com.aiton.weixinapliy.entity.WeixinapliyRequest;
import com.aiton.weixinapliy.service.WeiXinApliService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-22
 * Time: 下午1:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WeixinController {
    @RequestMapping("/weixin/test")
    @ResponseBody
    public void execute(WeixinapliyRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        WeiXinApliService service=new WeiXinApliService();
        String str=service.getData(request);
        System.out.println(str);
    }
}
