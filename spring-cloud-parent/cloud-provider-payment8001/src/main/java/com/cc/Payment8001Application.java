package com.cc;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @创建人 池臣
 * @创建时间 2020/5/24
 * @描述
 */
@SpringBootApplication(scanBasePackages = "com.cc")
public class Payment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Application.class, args);
    }
}
