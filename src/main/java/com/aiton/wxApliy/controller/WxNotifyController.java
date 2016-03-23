package com.aiton.wxApliy.controller;

import com.aiton.wxApliy.util.XMLUtil;
import org.jdom2.JDOMException;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-23
 * Time: 上午9:21
 * To change this template use File | Settings | File Templates.
 */
public class WxNotifyController {
    @RequestMapping("/wx/notify")
    public void notice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("notify方法");
        PrintWriter out = response.getWriter();
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        String result = new String(outSteam.toByteArray(), "utf-8");
        Map<String, String> map = null;
        try {
            map = XMLUtil.doXMLParse(result);
        } catch (JDOMException e) {
            e.printStackTrace();
        }
        System.out.println(map.toString());
    }
}
