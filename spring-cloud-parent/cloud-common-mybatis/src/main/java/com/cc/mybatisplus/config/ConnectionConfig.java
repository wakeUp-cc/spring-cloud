package com.cc.mybatisplus.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * @author 池臣
 * @data 2020/6/6
 */
@Configuration
@MapperScan("com.cc.**.mapper")
public class ConnectionConfig {

    @Bean("cloudSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("druidDataSource") DataSource ds, @Value("classpath*:mapper/**/*.xml") Resource[] mapperLocations) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setMapperLocations(mapperLocations);
        return bean.getObject();
    }

    @Bean("cloudSqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("cloudSqlSessionFactory") SqlSessionFactory sessionFactory) throws Exception {
        return new SqlSessionTemplate(sessionFactory);
    }

}
