package com.aiton.bmpw.Dao;

import com.aiton.bmpw.Entity.Picture;
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
