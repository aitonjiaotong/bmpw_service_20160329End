package com.aiton.bmpw.Service.impl;

import com.aiton.bmpw.Dao.OrderReponsitory;
import com.aiton.bmpw.Dao.Pw_RefundReponsitory;
import com.aiton.bmpw.Entity.Bmpw_Order;
import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Entity.Pw_Refund;
import com.aiton.bmpw.Service.pw_RefundService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-17
 * Time: 上午9:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class pw_RefundServiceImpl implements pw_RefundService {
    @Resource
    private Pw_RefundReponsitory refundReponsitory;
    @Resource
    private OrderReponsitory orderReponsitory;
    //添加退款表
    @Override
    public Pw_Refund addRedfund(Pw_Refund refund) {
        Bmpw_Order order=orderReponsitory.findOrderByBookLogAID(refund.getBookLogAID());
        refund.setFlag(1);
        refund.setPhone(order.getPhone());
        refund=refundReponsitory.saveAndFlush(refund);
        return refund;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Pw_Refund updateRedfund(String bookLogAID) {
        Pw_Refund refund=refundReponsitory.findOne(bookLogAID);
        refund.setFlag(0);
        refund=refundReponsitory.saveAndFlush(refund);
        return refund;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DataTables loadRefunds(Integer draw, Integer start, Integer length,HttpServletRequest request) {
        String search=request.getParameter("search[value]");
        Integer page=start/length;
        DataTables dataTables=new DataTables();
        dataTables.setRecordsTotal(refundReponsitory.count());
        List<String>s=new ArrayList<String>();
        s.add("flag");
        s.add("clsj");
        dataTables.setDraw(draw);
        if("".equals(search)){
            dataTables.setRecordsFiltered(refundReponsitory.count());
            dataTables.setData(refundReponsitory.findAll(new PageRequest(page,length,new Sort(Sort.Direction.DESC,s))).getContent());
        }else{
            String phone="%"+search+"%";
            dataTables.setData(refundReponsitory.findByphone(phone,new PageRequest(page,length,new Sort(Sort.Direction.DESC,s))).getContent());
            dataTables.setRecordsFiltered(Long.valueOf(refundReponsitory.CountByPhone(phone).toString()));
        }
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
