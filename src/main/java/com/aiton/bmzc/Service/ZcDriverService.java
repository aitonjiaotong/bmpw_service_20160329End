package com.aiton.bmzc.Service;

import com.aiton.bmzc.Entity.ZcContainsNum;
import com.aiton.bmzc.Entity.ZcDriver;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
public interface ZcDriverService {
    ZcContainsNum loadDriver(Integer page);
}
