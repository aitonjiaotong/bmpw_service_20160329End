package com.aiton.bmzc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-10
 * Time: 下午5:38
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ImageController {
    @RequestMapping("/image")
    @ResponseBody
    public void getImage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        InputStream input=request.getInputStream();
        ServletContext context=request.getServletContext();
        String str=context.getRealPath("/");
        String valueString = null;
        //System.out.println(request.getContextPath());
        File file=new File("cars/car.jpg");
        //System.out.println(file.getPath());
        if(!file.exists()){
            file.createNewFile();
        }
       FileOutputStream outputStream=new FileOutputStream(file);
       int a=0;
       while ((a=input.read())!=-1){
            outputStream.write(a);
       }
       outputStream.flush();;
       outputStream.close();
       input.close();
    }
}
