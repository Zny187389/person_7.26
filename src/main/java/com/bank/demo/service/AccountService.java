package com.bank.demo.service;

import com.bank.demo.pojo.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

public interface AccountService extends IService<Account> {

    boolean transfer(String source, String target, BigDecimal money);

}
