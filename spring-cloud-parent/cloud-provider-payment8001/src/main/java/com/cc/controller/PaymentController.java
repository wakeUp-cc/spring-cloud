package com.cc.controller;


import com.cc.common.entity.CommonResult;
import com.cc.common.entity.CommonResultStatusEnum;
import com.cc.mybatisplus.entity.Payment;
import com.cc.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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
    @GetMapping("/getById/{id}")
    public CommonResult<Payment> findPaymentById(@NotNull(message = "id不能为空") @PathVariable("id") Long id) {
        Payment payment = iPaymentService.getById(id);
        if (payment != null) {
            return new CommonResult<>(CommonResultStatusEnum.GET_SUCCESS.code, payment);
        }
        return new CommonResult<>(CommonResultStatusEnum.NOT_FOUND_ERROR.code, null);
    }

    /**
     * 新增支付记录
     *
     * @param payment
     * @return
     */
    @PostMapping("/addPayment")
    public CommonResult<String> addPayment(@RequestBody Payment payment) {
        if (payment != null) {
            iPaymentService.save(payment);
            return new CommonResult<String>(CommonResultStatusEnum.PUT_SUCCESS.code, CommonResultStatusEnum.PUT_SUCCESS.message);
        }
        return new CommonResult<String>(CommonResultStatusEnum.FORMAT_ERROR.code, CommonResultStatusEnum.FORMAT_ERROR.message);
    }

}
