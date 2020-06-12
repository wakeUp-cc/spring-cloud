package com.cc.controller;

import com.cc.common.entity.CommonResult;
import com.cc.feign.IPaymentFeignClient;
import com.cc.mybatisplus.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 池臣
 * @data 2020/6/6
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Autowired
    private IPaymentFeignClient paymentFeign;

    /**
     * 创建支付记录
     *
     * @param payment
     * @return
     */
    @PostMapping("/addPayment")
    public CommonResult addPayment(Payment payment) {
        return paymentFeign.addPayment(payment);
    }

    /**
     * 根据ID查询支付记录
     *
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        return paymentFeign.getById(id);
    }

}
