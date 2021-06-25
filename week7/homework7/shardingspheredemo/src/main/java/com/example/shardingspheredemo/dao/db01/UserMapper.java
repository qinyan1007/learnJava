package com.example.shardingspheredemo.dao.db01;

import org.apache.ibatis.annotations.Update;

/**
 * @author qinyan
 * @date 2021/6/25
 */
public interface UserMapper {
    @Update("update user set username = #{username} where id = #{uid}")
    int updateUserName(String username, Integer uid);
}
