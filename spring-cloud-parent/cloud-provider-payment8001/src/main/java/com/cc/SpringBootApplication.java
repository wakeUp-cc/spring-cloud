package com.cc;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

/**
 * @创建人 池臣
 * @创建时间 2020/5/24
 * @描述
 */
@MapperScan("com.cc.**.mapper")
@org.springframework.boot.autoconfigure.SpringBootApplication(scanBasePackages = "com.cc")
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
