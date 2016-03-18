package com.aiton.bmdc.dao;

import com.aiton.bmdc.entity.DCOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2016/3/17.
 */
public interface DCOrderRepository extends JpaRepository<DCOrder,Integer> {
}
