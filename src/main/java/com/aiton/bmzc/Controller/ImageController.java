package com.aiton.bmzc.Controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

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
        ServletContext context=request.getServletContext();
        String str=context.getRealPath("/");
        String savepath=str+"WEB-INF"+File.separator+"pages"+File.separator+"cars"+File.separator;
        File file=new File(savepath);
        if(!file.exists()){
            file.mkdirs();
        }
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("utf-8");
        List fileList = null;
        try {
            fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            return;
        }
        Iterator<FileItem> it = fileList.iterator();
        String name="";
        String extName="";
        while(it.hasNext()){
            FileItem item=it.next();
            if(!item.isFormField()){
                name=item.getName();
                if(name==null||name.trim().equals("")){
                    continue;
                }
                if(name.lastIndexOf(".")>=0){
                    extName=name.substring(name.lastIndexOf("."));
                }
                File file1=new File(savepath+name+extName);
                name="car";
                if(!file1.exists()){
                    file1.createNewFile();
                }
                try {
                    item.write(file1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name+extName);
        PrintWriter pw=response.getWriter();
        pw.print(name + extName);
        pw.close();
    }
}
