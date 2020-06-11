package com.cc.mybatisplus.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author 池臣
 * @data 2020/6/6
 */
@Configuration
@PropertySource("classpath:config.properties")
public class DataSourceConfig {

    @Value("${data.source.url}")
    private String url;
    @Value("${data.source.username}")
    private String username;
    @Value("${data.source.password}")
    private String password;
    @Value("${data.source.driverClassName}")
    private String driverClassName;

    @Bean("druidDataSource")
    //@ConfigurationProperties(prefix = "data.source") TODO 为什么这个没用
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }

}
