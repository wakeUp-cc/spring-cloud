package com.cc.mybatisplus.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * @author 池臣
 * @data 2020/6/6
 */
@MapperScan("com.cc.**.mapper")
public class ConnectionConfig {

    @Bean
    public SqlSessionFactory getSqlSessionFactory(DataSource ds, @Value("classpath*:mapper/**/*.xml") Resource[] mapperLocations) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setMapperLocations(mapperLocations);
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sessionFactory) throws Exception{
        return new SqlSessionTemplate(sessionFactory);
    }

}
