package com.aiton.bmgj.dao;

import com.aiton.bmgj.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2016/3/3.
 */
public interface DriverRepository extends JpaRepository<Driver,Integer> {
}
