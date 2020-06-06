package com.cc.controller;

import com.cc.common.entity.CommonResult;
import com.cc.mybatisplus.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 池臣
 * @data 2020/6/6
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Value("${http.payment.url}")
    private String paymentUrl;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 创建支付记录
     *
     * @param payment
     * @return
     */
    @PostMapping("/addPayment")
    public CommonResult addPayment(Payment payment) {
        return restTemplate.postForObject(paymentUrl + "/payment/addPayment", payment, CommonResult.class);
    }

    /**
     * 根据ID查询支付记录
     *
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(paymentUrl + "/payment/getById/" + id, CommonResult.class);
    }

}
