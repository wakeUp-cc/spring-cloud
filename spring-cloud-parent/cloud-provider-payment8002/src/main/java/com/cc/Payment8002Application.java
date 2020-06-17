package com.cc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @创建人 池臣
 * @创建时间 2020/5/24
 * @描述
 */
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.cc")
public class Payment8002Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002Application.class, args);
    }
}
