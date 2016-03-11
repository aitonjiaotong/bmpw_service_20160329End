package com.aiton.bmpw.Service.impl;

import com.aiton.bmpw.Dao.AccountReponstory;
import com.aiton.bmpw.Dao.OrderReponsitory;
import com.aiton.bmpw.Dao.RedEnvelopeReponsitory;
import com.aiton.bmpw.Entity.Account;
import com.aiton.bmpw.Entity.Bmpw_Order;
import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Entity.RedEnvelope;
import com.aiton.bmpw.Entity.Show.Order_show;
import com.aiton.bmpw.Entity.Show.pw_Order_show;
import com.aiton.bmpw.Service.OrderService;
import com.aiton.bmpw.Util.GsonUtils;
import com.aiton.bmpw.Webservice.JDTTicketLocator;
import com.aiton.bmpw.Webservice.JDTTicketSoap_PortType;
import net.sf.json.JSONObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-24
 * Time: 上午8:53
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderServiceimpl implements OrderService {
    @Resource
    private OrderReponsitory orderReponsitory;
    @Resource
    private RedEnvelopeReponsitory redEnvelopeReponsitory;
    @Resource
    private AccountReponstory accountReponstory;
    @Override
    public Bmpw_Order addOrder(String BookLogAID, Integer account_id) {
        Bmpw_Order order=new Bmpw_Order();
        order.setBookLogAID(BookLogAID);
        order.setAccount_id(account_id);
        Account account=accountReponstory.findOne(account_id);
        order.setPhone(account.getPhone());
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order=orderReponsitory.saveAndFlush(order);
        account=null;
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public pw_Order_show loadOrderByUserId(Integer account_id,Integer page) {
        List<Bmpw_Order>orders=orderReponsitory.findByUserId(account_id,new PageRequest(page,8,new Sort(Sort.Direction.DESC,"date"))).getContent();
        double sum=Double.valueOf(orderReponsitory.CountByAccount(account_id).toString());
        int pages=(int) StrictMath.ceil(sum/8);
        pw_Order_show order_show=new pw_Order_show();
        order_show.setOrders(orders);
        order_show.setPages(pages);
        return order_show;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DataTables loadOrders(Integer draw, Integer start, Integer length,HttpServletRequest request) throws ServiceException, RemoteException {
        String search=request.getParameter("search[value]");
        Integer page=start/length;
        JDTTicketLocator jdtTicketLocator=new JDTTicketLocator();
        JDTTicketSoap_PortType jdtTicketSoap_portType=jdtTicketLocator.getJDTTicketSoap();
        //jdtTicketSoap_portType.queryBookLog();
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        dataTables.setRecordsTotal(orderReponsitory.count());
        List<Order_show> orders=new ArrayList<Order_show>();
        List<Bmpw_Order>bmpw_orders=new ArrayList<Bmpw_Order>();
        if(search==""){
            bmpw_orders=orderReponsitory.findAll(new PageRequest(page,length,new Sort(Sort.Direction.DESC,"date"))).getContent();
            dataTables.setRecordsFiltered(orderReponsitory.count());
        }else{
            search="%"+search+"%";
            Long count=Long.valueOf(orderReponsitory.CountPhoneLike(search).toString());
            dataTables.setRecordsFiltered(count);
            bmpw_orders=orderReponsitory.findPhoneLike(search,new PageRequest(page,length,new Sort(Sort.Direction.DESC,"date"))).getContent();

        }
            for(Bmpw_Order bmpw_order:bmpw_orders){
            String str=jdtTicketSoap_portType.queryBookLog(bmpw_order.getBookLogAID());
            Order_show order=GsonUtils.parseJSON(str,Order_show.class);
            JSONObject jsonObject=JSONObject.fromObject(str);
            String ste=jsonObject.get("BookTime").toString();
            ste=ste.substring(ste.indexOf("(")+1,ste.indexOf(")"));
            order.setDate(new Timestamp(Long.valueOf(ste)));
            if(bmpw_order.getRedEnvelope_id()!=null){
                RedEnvelope redEnvelope=redEnvelopeReponsitory.findOne(bmpw_order.getRedEnvelope_id());
                order.setAmount(redEnvelope.getAmount());
                redEnvelope=null;
            }else{
                order.setAmount(0.00);
            }
            orders.add(order);
            order=null;
        }
        dataTables.setData(orders);
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Bmpw_Order completeOrder(Integer order_id, Integer redEnvelope_id) {
        Bmpw_Order order=orderReponsitory.findOne(order_id);
        if(redEnvelope_id!=null){
            RedEnvelope redEnvelope=redEnvelopeReponsitory.findOne(redEnvelope_id);
            order.setRedEnvelope_id(redEnvelope_id);
            redEnvelope.setFlag(1);
            order=orderReponsitory.saveAndFlush(order);
            redEnvelopeReponsitory.saveAndFlush(redEnvelope);
        }
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
