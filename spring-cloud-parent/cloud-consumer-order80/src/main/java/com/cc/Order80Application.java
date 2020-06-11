package com.cc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @创建人 池臣
 * @创建时间 2020/6/6
 * @描述
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.cc")
public class Order80Application {
    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class, args);
    }
}
