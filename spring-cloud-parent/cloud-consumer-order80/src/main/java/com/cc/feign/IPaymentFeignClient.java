package com.cc.feign;

import com.cc.common.entity.CommonResult;
import com.cc.hystrix.PaymentFeignFallback;
import com.cc.mybatisplus.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 池臣
 * @data 2020/6/12
 * feign调用
 */
@FeignClient(name = "cloud-eureka-payment", fallbackFactory = PaymentFeignFallback.class)
public interface IPaymentFeignClient {

    /**
     * 获取订单记录
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/payment/getById/{id}")
    CommonResult getById(@PathVariable("id") Long id);

    /**
     * 新增支付记录
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment/addPayment")
    CommonResult addPayment(Payment payment);
}
