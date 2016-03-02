package com.aiton.bmpw.Dao;

import com.aiton.bmpw.Entity.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-5
 * Time: 下午5:24
 * To change this template use File | Settings | File Templates.
 */
public interface SiteReponstory extends JpaRepository<Site,Integer> {
    @Query("from Site where flag=0")
    List<Site> findSite();
    @Query("select site from Site as site where siteCode like ?")
    Page<Site> findSiteWhereSiteCodeLike(String str,Pageable pageable);
    @Query("select count(s) from Site as s where siteCode like ?")
    Object findCountOfSiteCoodeLike(String str);
}
