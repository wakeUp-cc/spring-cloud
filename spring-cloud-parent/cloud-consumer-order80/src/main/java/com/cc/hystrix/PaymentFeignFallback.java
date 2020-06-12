package com.cc.hystrix;

import com.cc.common.entity.CommonResult;
import com.cc.common.entity.CommonResultStatusEnum;
import com.cc.feign.IPaymentFeignClient;
import com.cc.mybatisplus.entity.Payment;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 池臣
 * @data 2020/6/12
 * 服务降级容错
 */
@Slf4j
@Component
public class PaymentFeignFallback implements FallbackFactory<IPaymentFeignClient> {

    private CommonResult commonResult=new CommonResult(CommonResultStatusEnum.ERROR.code, "请求异常,请及时与管理员联系");

    @Override
    public IPaymentFeignClient create(Throwable throwable) {
        return new IPaymentFeignClient() {
            @Override
            public CommonResult getById(Long id) {
                log.error("服务进入容错处理,错误原因:[{}]", throwable.getMessage());
                return commonResult;
            }

            @Override
            public CommonResult addPayment(Payment payment) {
                log.error("服务进入容错处理,错误原因:[{}]", throwable.getMessage());
                return commonResult;
            }
        };
    }

}
