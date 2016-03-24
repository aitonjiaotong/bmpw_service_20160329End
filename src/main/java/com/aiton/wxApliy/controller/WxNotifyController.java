package com.aiton.wxApliy.controller;

import com.aiton.wxApliy.util.XMLUtil;
import org.jdom2.JDOMException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-23
 * Time: 上午9:21
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WxNotifyController {
    @RequestMapping("/wx/notify")
    public void notice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //System.out.println("notify方法");
//        PrintWriter out = response.getWriter();
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
        //System.out.println("oo"+result);
        Map<String, String> map = null;
        try {
            map = XMLUtil.doXMLParse(result);
        } catch (JDOMException e) {
            e.printStackTrace();
        }
        ServletContext context=request.getServletContext();
        String str=context.getRealPath("/");
        String savepath=str+"WEB-INF"+File.separator+"pages"+File.separator+"cars"+File.separator+"o.txt";
        File file=new File(savepath);
        if(!file.exists()){
            file.createNewFile();
        }
        PrintWriter pw=new PrintWriter(new FileWriter(file));
        pw.println("接收到的数据"+map.toString());
        pw.flush();
        pw.close();
        //System.out.println(map.toString());
    }
}
