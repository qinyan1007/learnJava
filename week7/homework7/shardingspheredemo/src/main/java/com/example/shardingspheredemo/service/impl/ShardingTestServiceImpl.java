package com.example.shardingspheredemo.service.impl;

import com.example.shardingspheredemo.dao.db01.UserMapper;
import com.example.shardingspheredemo.dao.db02.AccountMapper;
import com.example.shardingspheredemo.service.ShardingTestService;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author qinyan
 * @date 2021/6/25
 */
@Service
public class ShardingTestServiceImpl implements ShardingTestService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    AccountMapper accountMapper;

    @Override
    @ShardingTransactionType(TransactionType.XA)
    @Transactional
    public void testTransaction() {
        int userResult = userMapper.updateUserName("jiyuge", 1);
        int accountResult = accountMapper.accountAddBalance(BigDecimal.ONE, 1);
        System.out.println("用户表返回数量：" + userResult);
        System.out.println("账户表返回数量："+ accountResult);
//        throw new RuntimeException("我是一个异常");
    }
}
