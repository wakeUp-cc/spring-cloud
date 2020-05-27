package com.cc;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

/**
 * @创建人 池臣
 * @创建时间 2020/5/24
 * @描述
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan("com.cc.**.mapper")
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
