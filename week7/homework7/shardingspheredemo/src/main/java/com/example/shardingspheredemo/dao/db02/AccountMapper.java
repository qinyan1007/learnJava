package com.example.shardingspheredemo.dao.db02;

import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * @author qinyan
 * @date 2021/6/25
 */
public interface AccountMapper {
    @Update("update account set balance = balance + #{amount} where id = #{id}")
    int accountAddBalance(BigDecimal amount, Integer id);
}
