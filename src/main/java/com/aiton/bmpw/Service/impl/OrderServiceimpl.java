package com.aiton.bmpw.service.impl;

import com.aiton.bmpw.dao.AccountReponstory;
import com.aiton.bmpw.dao.OrderReponsitory;
import com.aiton.bmpw.dao.RedEnvelopeReponsitory;
import com.aiton.bmpw.entity.Account;
import com.aiton.bmpw.entity.Bmpw_Order;
import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmpw.entity.RedEnvelope;
import com.aiton.bmpw.entity.show.Order_show;
import com.aiton.bmpw.entity.show.pw_Order_show;
import com.aiton.bmpw.service.OrderService;
import com.aiton.bmpw.util.GsonUtils;
import com.aiton.bmpw.Webservice.JDTTicketLocator;
import com.aiton.bmpw.Webservice.JDTTicketSoap_PortType;
import net.sf.json.JSONObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
        if("".equals(search)){
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
        if(redEnvelope_id<1){
           return null;
        }
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

    @Override
    public Bmpw_Order exceptionOrder(Integer order_id, Integer flag) {
        Bmpw_Order order=orderReponsitory.findOne(order_id);
        if(flag.equals(1)||flag==1){
           order.setFlag(0);
        }
        order=orderReponsitory.saveAndFlush(order);
        return order;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean checkOrder(Integer order_id) {
        HttpURLConnection httpConn=null;
        BufferedReader in=null;
        try{
            Bmpw_Order order=orderReponsitory.findOne(order_id);
            String message=order.getBookLogAID();
            String path="http://www.aiton.com.cn:808/JDTTicket.asmx/SellTicket_NoBill_Confirm?scheduleCompanyCode=YongAn&bookLogAID="+message;
            URL url=new URL(path);
            httpConn=(HttpURLConnection)url.openConnection();
            if(httpConn.getResponseCode()==HttpURLConnection.HTTP_OK){
                StringBuffer content=new StringBuffer();
                String tempStr="";
                in=new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                while((tempStr=in.readLine())!=null){
                    content.append(tempStr);
                }
                String str=content.toString();
 //               str=new String(str.getBytes(),"UTF-8");
//                System.out.println(str);
                if(str.equals("")){
                    return false;
                }
                order.setFlag(1);
                orderReponsitory.saveAndFlush(order);
            }else{
                throw new Exception("请求出现了问题!");
            }
            return true;
        }catch(Exception e){
            return false;
        }finally {
            httpConn.disconnect();
        }
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public DataTables loadExceptionOrders(Integer draw, Integer start, Integer length, HttpServletRequest request) {
        Integer page=start/length;
        String search=request.getParameter("search[value]");
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        List<Bmpw_Order>orders=orderReponsitory.findExceptionOrders(new PageRequest(page,length)).getContent();
        dataTables.setRecordsTotal((long)orders.size());
        if("".equals(search)){
            dataTables.setData(orders);
            dataTables.setRecordsFiltered((long)orders.size());
        }else{
            search="%"+search+"%";
            dataTables.setData(orderReponsitory.findExceptionPhoneLike(search,new PageRequest(page,length)).getContent());
            dataTables.setRecordsFiltered(Long.valueOf(orderReponsitory.CountExceptionPhoneLike(search).toString()));
        }
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
