package com.cc.common.error;

import com.cc.common.exceptions.MessageException;
import com.cc.common.result.CommonResult;
import com.cc.common.result.CommonResultStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 池臣
 * @data 2020/5/27
 * 统一异常处理
 */
@RestControllerAdvice
public class UnifiedExceptionHandling {

    @ExceptionHandler(value = MessageException.class)
    public CommonResult<String> jsonErrorHandler(MessageException e) throws Exception {
        return new CommonResult<>(CommonResultStatus.FAILURE, e.getMessage());
    }

}
