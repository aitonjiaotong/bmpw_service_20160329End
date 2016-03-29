package com.aiton.bmzc.service.impl;

import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmzc.dao.ZcAppointmentRespository;
import com.aiton.bmzc.entity.ZcAppointment;
import com.aiton.bmzc.service.ZcAppointmentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-21
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ZcAppointmentServiceImpl implements ZcAppointmentService {
    @Resource
    private ZcAppointmentRespository appointmentRespository;
    @Override
    public DataTables findAppointments(Integer draw, Integer start, Integer length, String search) {
        Integer page=start/length;
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        dataTables.setRecordsTotal(appointmentRespository.count());
        if(search==null||"".equals(search)){
            dataTables.setRecordsFiltered(appointmentRespository.count());
            dataTables.setData(appointmentRespository.findAll(new PageRequest(page,length,new Sort(Sort.Direction.DESC,"appointmenttime"))).getContent());
        }
        else{
            search="%"+search+"%";
            dataTables.setRecordsFiltered(Long.valueOf(appointmentRespository.CountByNameLike(search).toString()));
            dataTables.setData(appointmentRespository.findByNameLike(search,new PageRequest(page,length,new Sort(Sort.Direction.DESC,"appointmenttime"))));
        }
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean addAppointmentFromPage(ZcAppointment appointment) {
        if(appointment.getId()!=null){
            return false;
        }
        try {
            appointmentRespository.saveAndFlush(appointment);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
