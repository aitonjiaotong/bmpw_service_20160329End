package com.aiton.bmpw.Controller.FrontController.PictureController;

import com.aiton.bmpw.Entity.Picture;
import com.aiton.bmpw.Service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 上午9:23
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class getBannerController {
    @Resource
    private PictureService pictureService;
    @RequestMapping("/picture/getpictures")
    @ResponseBody
    public List<Picture> execute(){
        List<Picture>pictures=pictureService.getPictures();
        return pictures;
    }
}
