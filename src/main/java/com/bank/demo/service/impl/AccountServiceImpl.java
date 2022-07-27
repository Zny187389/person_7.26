package com.bank.demo.service.impl;

import com.bank.demo.mapper.AccountMapper;
import com.bank.demo.pojo.Account;
import com.bank.demo.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    private Integer i1;
    private Integer i2;

    //开启事务
    @Transactional
    @Override
    public boolean transfer(String source, String tsrget, BigDecimal money){
        //获取汇款方
        QueryWrapper<Account> wrapper1= new QueryWrapper<>();
        wrapper1.eq("name",source);
        Account one1 = accountMapper.selectOne(wrapper1);

        QueryWrapper<Account> wrapper2= new QueryWrapper<>();
        wrapper2.eq("name",tsrget);
        Account one2 = accountMapper.selectOne(wrapper2);

        one1.setMoney(one1.getMoney().subtract(money));
        i1 = accountMapper.updateById(one1);
        //模拟转账异常
      //  int a=1/0;

        one2.setMoney(one2.getMoney().add(money));
        i2 = accountMapper.updateById(one2);
        if (i1 > 0 && i2 > 0){
            return true;
        }
        return false;
    }
}
