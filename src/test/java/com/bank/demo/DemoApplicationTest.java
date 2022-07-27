package com.bank.demo;

import com.bank.demo.pojo.Account;
import com.bank.demo.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootTest
public class DemoApplicationTest {

    @Autowired
    private AccountService accountService;

    @Test
    void contextLoads(){

        boolean b = accountService.transfer("A","B", BigDecimal.valueOf(700D));
        if(b){
            System.out.println("转账成功！");
        }else{
            System.out.println("转账异常！");
        }
    }
}
