package com.example.abstractroutingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AbstractroutingdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbstractroutingdemoApplication.class, args);
    }

}
