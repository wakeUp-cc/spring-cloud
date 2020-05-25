package com.cc.controller;


import com.cc.common.result.CommonResult;
import com.cc.common.result.CommonResultStatus;
import com.cc.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 池臣
 * @since 2020-05-25
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService iPaymentService;

    //TODO 考虑使用统一异常处理
    @GetMapping("/test")
    public CommonResult test(String b) {
        return new CommonResult(CommonResultStatus.SUCCESS, b);
    }

}
