package com.aiton.bmpw.Service.impl;

import com.aiton.bmpw.Dao.AccountReponstory;
import com.aiton.bmpw.Dao.PictureRepostory;
import com.aiton.bmpw.Dao.RedEnvelopeReponsitory;
import com.aiton.bmpw.Entity.Account;
import com.aiton.bmpw.Entity.DataTables;
import com.aiton.bmpw.Entity.Picture;
import com.aiton.bmpw.Entity.RedEnvelope;
import com.aiton.bmpw.Entity.Show.RedEnvelope_show;
import com.aiton.bmpw.Service.RedEnvelopeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-18
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RedEnvelopeServiceImpl implements RedEnvelopeService {
    @Resource
    private RedEnvelopeReponsitory redEnvelopeReponsitory;
    @Resource
    private AccountReponstory accountReponstory;
    @Resource
    private PictureRepostory pictureRepostory;
    /**
     * 设置红包过期
     */
    @Override
    public void setRedEnvelopeOverdue() {
        List<RedEnvelope>redEnvelopes=redEnvelopeReponsitory.findRedEnvelopeNotOverDue();
        long date=System.currentTimeMillis();
        for(RedEnvelope redEnvelope:redEnvelopes){
            if(redEnvelope.getValidity().getTime()<date){
                redEnvelope.setFlag(2);
                redEnvelopeReponsitory.saveAndFlush(redEnvelope);
            }
        }

        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *生成红包
     * @param sum 生成数量
     * @param validity 红包截至时间
     * @param max 红包最大金额
     * @param min 红包最小金额
     */
    @Override
    public void addRedEnvelope(Integer sum, Date validity, Double max, Double min) {
        Random ran=new Random();
        Integer activity=Integer.valueOf(redEnvelopeReponsitory.findMaxAcitvity().toString());
        if(activity==null){
            activity=1;
        }else{
            activity=activity+1;
        }
        if(max==min){
            for(int i=0;i<sum;i++){
                RedEnvelope redEnvelope=new RedEnvelope();
                redEnvelope.setValidity(validity);
                redEnvelope.setAmount(max);
                redEnvelope.setDate(new Timestamp(System.currentTimeMillis()));
                redEnvelope.setFlag(0);
                redEnvelope.setActivity(activity);
                redEnvelopeReponsitory.saveAndFlush(redEnvelope);
                redEnvelope=null;
            }
        }else{
            for(int i=0;i<sum;i++){
                RedEnvelope redEnvelope=new RedEnvelope();
                redEnvelope.setValidity(validity);
                redEnvelope.setDate(new Timestamp(System.currentTimeMillis()));
                redEnvelope.setFlag(0);
                Integer a=(int)(max-min);
                Double amount=ran.nextInt(a+1)+min;
                redEnvelope.setAmount(amount);
                redEnvelope.setActivity(activity);
                redEnvelopeReponsitory.saveAndFlush(redEnvelope);
                redEnvelope=null;
            }
        }
        Picture picture=pictureRepostory.findOne(1);
        picture.setUrl2("http://120.24.46.15:8080/bmpw/front/getRedEnvelope?activity="+activity);
        pictureRepostory.saveAndFlush(picture);
        //To change body of implemented methods use File | Settings | File Templates.
    }
    /**
     * 用户获取红包
     * @param user_id
     * @return
     */
    @Override
    public RedEnvelope getRedEnvelope(Integer user_id,Integer activity) {
        setRedEnvelopeOverdue();
        List<RedEnvelope>redEnvelopes=redEnvelopeReponsitory.findRedEnvelope(activity);
        RedEnvelope redEnvelope=redEnvelopeReponsitory.findByActivityAndUserID(user_id,activity);
        if(!redEnvelopes.isEmpty()&redEnvelope==null){
            Integer length=redEnvelopes.size();
            Random ran=new Random();
            Integer o=ran.nextInt(length-1);
            redEnvelope=redEnvelopes.get(o);
            redEnvelope.setUser_id(user_id);
            redEnvelopeReponsitory.saveAndFlush(redEnvelope);
            return redEnvelope;
        }else{
            return null;
        }
         //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 查询用户的红包
     * @param user_id
     * @return
     */
    @Override
    public List<RedEnvelope> getUserRedEnvelope(Integer user_id) {
        setRedEnvelopeOverdue();
        List<RedEnvelope>redEnvelopes=redEnvelopeReponsitory.findRedEnvelopeByUser_id(user_id);
        return redEnvelopes;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * 查询所有的红包（根据创建时间排序）
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @Override
    public DataTables loadAllRedEnvelope(Integer draw, Integer start, Integer length,HttpServletRequest request) {
        String search=request.getParameter("search[value]");
//        String search="";
        Integer page=start/length;

        List<RedEnvelope>redEnvelopes=new ArrayList<RedEnvelope>();
        List<RedEnvelope_show>redEnvelope_shows=new ArrayList<RedEnvelope_show>();
        DataTables dataTables=new DataTables();
        dataTables.setDraw(draw);
        dataTables.setRecordsTotal(redEnvelopeReponsitory.count());
        //如果没有搜索条件
        if("".equals(search)){
           redEnvelopes=redEnvelopeReponsitory.findAll(new PageRequest(page,length,new Sort(Sort.Direction.DESC,"date"))).getContent();
            dataTables.setRecordsFiltered(redEnvelopeReponsitory.count());
        }else{
            search="%"+search+"%";
            List<Object>account_ids=accountReponstory.findByNameLike(search);
            for(Object account_id:account_ids){
                List<RedEnvelope>redEnvelopes1=redEnvelopeReponsitory.findRedEnvelopeByUser_id((Integer)account_id);
                redEnvelopes.addAll(redEnvelopes1);

            }
            dataTables.setRecordsFiltered((long)redEnvelopes.size());
        }
        for(RedEnvelope redEnvelope:redEnvelopes){
            RedEnvelope_show redEnvelope_show=new RedEnvelope_show();
            Integer user_id=redEnvelope.getUser_id();
            if(user_id!=null){
                Account account=accountReponstory.findOne(redEnvelope.getUser_id());
                redEnvelope_show.setAccountName(account.getName());
            }else{
                redEnvelope_show.setAccountName("");
            }
            redEnvelope_show.setId(redEnvelope.getId());
            redEnvelope_show.setAmount(redEnvelope.getAmount());
            redEnvelope_show.setDate(redEnvelope.getDate());
            redEnvelope_show.setValidity(redEnvelope.getValidity());
            redEnvelope_shows.add(redEnvelope_show);
        }


        dataTables.setData(redEnvelope_shows);
        return dataTables;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Integer delRedEnvelope(Integer id) {
        RedEnvelope redEnvelope=redEnvelopeReponsitory.findOne(id);
        System.out.println(redEnvelope==null);
        if(redEnvelope==null){
            return 1;
        }
        redEnvelopeReponsitory.delete(id);
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
