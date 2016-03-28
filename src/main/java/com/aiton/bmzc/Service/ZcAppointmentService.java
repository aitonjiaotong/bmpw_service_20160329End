package com.aiton.bmzc.Service;

import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmzc.Entity.ZcAppointment;

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
