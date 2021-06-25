package com.example.abstractroutingdemo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author qinyan
 * @date 2021/6/24
 */
public class DataSourceRouter extends AbstractRoutingDataSource {
    //默认主库
    private static String dataSourceconfig = "master";
    @Override
    protected Object determineCurrentLookupKey() {
//        log.info(" 当前数据源: " + DataSourceContextHolder.getCurrentDataSource());
//        return DataSourceContextHolder.getCurrentDataSource();
        return dataSourceconfig;
    }


    public static void setMater() {
        dataSourceconfig = "master";
        System.out.println("设置为主库");
    }
    public static void setSlave() {
        dataSourceconfig = "slave";
        System.out.println("设置为从库");
    }
}
