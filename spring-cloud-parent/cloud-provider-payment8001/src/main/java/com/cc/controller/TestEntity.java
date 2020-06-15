package com.cc.controller;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 池臣
 * @data 2020/6/15
 */
@Data
@ToString
@Component
public class TestEntity {
    @Value("${mysql.url}")
    private String test1;
    @Value("${mysql.username}")
    private String test2;
    @Value("${mysql.password}")
    private String test3;
}
