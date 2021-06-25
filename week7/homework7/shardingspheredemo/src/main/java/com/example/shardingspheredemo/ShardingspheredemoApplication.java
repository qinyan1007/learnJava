package com.example.shardingspheredemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

@SpringBootApplication(exclude = JtaAutoConfiguration.class,scanBasePackages = {
        "com.example"
})
@MapperScan(basePackages = "com.example.shardingspheredemo.dao")
public class ShardingspheredemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingspheredemoApplication.class, args);
    }
}
