package com.aiton.bmpw.dao;

import com.aiton.bmpw.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-29
 * Time: 上午9:29
 * To change this template use File | Settings | File Templates.
 */
public interface PictureRepostory extends JpaRepository<Picture,Integer>{
}
