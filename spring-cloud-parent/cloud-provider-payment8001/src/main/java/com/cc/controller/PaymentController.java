package com.cc.controller;


import com.cc.common.result.CommonResult;
import com.cc.common.result.CommonResultStatus;
import com.cc.entity.Payment;
import com.cc.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 池臣
 * @since 2020-05-25
 */
@Validated
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService iPaymentService;

    /**
     * 根据ID查询支付记录
     *
     * @param id
     * @return
     */
    @GetMapping("/findPaymentById/{id}")
    public CommonResult<Payment> findPaymentById(@Max(message = "ID不能大于10",value = 10) @PathVariable("id") Long id) {
        return new CommonResult<>(CommonResultStatus.SUCCESS, iPaymentService.getById(id));
    }

}
