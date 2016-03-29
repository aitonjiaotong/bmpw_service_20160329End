package com.aiton.bmzc.service;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmzc.entity.ZcAppointment;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 下午4:37
 * To change this template use File | Settings | File Templates.
 */
public interface ZcAppointmentService {
    DataTables findAppointments(Integer draw,Integer start,Integer length,String search);
    boolean addAppointmentFromPage(ZcAppointment appointment);
}
