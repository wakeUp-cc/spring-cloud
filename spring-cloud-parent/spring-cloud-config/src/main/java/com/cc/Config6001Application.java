package com.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 池臣
 * @data 2020/6/15
 */
@EnableConfigServer
@SpringBootApplication
public class Config6001Application {
    public static void main(String[] args) {
        SpringApplication.run(Config6001Application.class, args);
    }
}
