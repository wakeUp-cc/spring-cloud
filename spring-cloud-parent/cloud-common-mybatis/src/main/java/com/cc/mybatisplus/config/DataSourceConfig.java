package com.cc.mybatisplus.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 池臣
 * @data 2020/6/6
 */
@Configuration
public class DataSourceConfig {

    @Value("${mysql.druid.url}")
    private String url;
    @Value("${mysql.druid.username}")
    private String username;
    @Value("${mysql.druid.password}")
    private String password;
    @Value("${mysql.druid.driverClassName}")
    private String driverClassName;

    @Bean("druidDataSource")
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }
}
