package com.aiton.bmpw.Controller.ModelController.RedEnvelope;

import com.aiton.bmpw.Service.RedEnvelopeService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-22
 * Time: 下午2:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional
public class AddRedEnvelopeController {
    @Resource
    private RedEnvelopeService service;
    @RequestMapping("/redEnvelope/addRedEnvelope")
    @ResponseBody
    public Integer execute(Integer sum,String validity,Double max,Double min) throws ParseException {
//        System.out.println(validity);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date(sdf.parse(validity).getTime());
        if(date.getTime()<System.currentTimeMillis()){
            return 1;
        }
        service.addRedEnvelope(sum,date,max,min);
        return 0;
    }
}
