package com.aiton.bmzc.service.impl;

import com.aiton.bmpw.dao.AccountReponstory;
import com.aiton.bmpw.entity.Account;
import com.aiton.bmpw.entity.DataTables;
import com.aiton.bmzc.service.ZcAccountService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-19
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ZcAccountServiceImpl implements ZcAccountService {
    @Resource
    private AccountReponstory accountReponstory;
    @Override
    public DataTables loadAccounts(Integer draw, Integer start, Integer length,HttpServletRequest request) {
        DataTables dataTables=new DataTables();
        Integer page=start/length;
        String search=request.getParameter("search[value]");
        dataTables.setRecordsTotal(accountReponstory.count());
        dataTables.setDraw(draw);
        if("".equals(search)||search==null){
            dataTables.setData(accountReponstory.findAll(new PageRequest(page,length)).getContent());
            dataTables.setRecordsFiltered(accountReponstory.count());
        }else{
            search="%"+search+"%";
            dataTables.setData(accountReponstory.findByPhoneLike(search,new PageRequest(page,length)));
            dataTables.setRecordsFiltered(Long.valueOf(accountReponstory.CountByPhoneLike(search).toString()));
        }
        return dataTables;
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**添加客户信息*/
    @Override
    public boolean addAccount(Account account) {
        if(account.getId()!=null){
            return false;
        }
        try {
            accountReponstory.saveAndFlush(account);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**更新客户信息*/
    @Override
    public boolean updateAccount(Account account) {
        if(account.getId() == null){
            return false;
        }
        try{
            accountReponstory.saveAndFlush(account);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
