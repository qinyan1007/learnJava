package com.example.shardingspheredemo.controller;

import com.example.shardingspheredemo.service.ShardingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinyan
 * @date 2021/6/25
 */
@RestController
public class DemoController {
    @Autowired
    ShardingTestService shardingTest;

    @RequestMapping("/demo")
    public String demo (){
        return "我是demo";
    }


    @RequestMapping("/sharding")
    public String sharding(){
        shardingTest.testTransaction();
        return "分布式事务提交成功success";
    }
}
