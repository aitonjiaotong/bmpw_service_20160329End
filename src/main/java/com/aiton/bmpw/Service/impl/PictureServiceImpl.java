package com.aiton.bmpw.Service.impl;

import com.aiton.bmpw.Dao.PictureRepostory;
import com.aiton.bmpw.Entity.Picture;
import com.aiton.bmpw.Service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 上午9:33
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PictureServiceImpl implements PictureService{
    @Resource
    private PictureRepostory pictureRepostory;
    @Override
    public List<Picture> getPictures() {
        List<Picture>pictures=pictureRepostory.findAll();
        return pictures;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
