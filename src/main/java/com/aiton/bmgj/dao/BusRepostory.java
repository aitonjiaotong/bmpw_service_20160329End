package com.aiton.bmgj.dao;

import com.aiton.bmgj.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2016/3/3.
 */
public interface BusRepostory extends JpaRepository<Bus,Integer> {
}
