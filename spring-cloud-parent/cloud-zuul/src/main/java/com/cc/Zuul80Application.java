package com.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 池臣
 * @data 2020/6/12
 */
@RefreshScope
@EnableZuulProxy
@SpringBootApplication
public class Zuul80Application {
    public static void main(String[] args) {
        SpringApplication.run(Zuul80Application.class, args);
    }
}
