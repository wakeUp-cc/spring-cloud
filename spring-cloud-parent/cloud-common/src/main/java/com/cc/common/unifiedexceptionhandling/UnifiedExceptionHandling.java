package com.cc.common.unifiedexceptionhandling;

import com.cc.common.entity.CommonResult;
import com.cc.common.entity.CommonResultStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author 池臣
 * @data 2020/5/27
 * 统一异常处理
 */
@Slf4j
@RestControllerAdvice
public class UnifiedExceptionHandling {

    /**
     * 对异常进行统一管理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> jsonErrorHandler(Exception e) {
        String message;
        CommonResultStatusEnum commonResultStatusEnum = CommonResultStatusEnum.ERROR;
        if (e instanceof ConstraintViolationException) {
            commonResultStatusEnum = CommonResultStatusEnum.FORMAT_ERROR;
            //参数校验异常
            ConstraintViolationException cve = (ConstraintViolationException) e;
            StringBuilder sb = new StringBuilder();
            cve.getConstraintViolations().forEach(constraintViolation -> {
                sb.append(constraintViolation.getMessage()).append(",");
            });
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            message = sb.toString();
        } else {
            message = CommonResultStatusEnum.ERROR.message;
            StackTraceElement[] stackTrace = e.getStackTrace();
            log.error("系统发生异常,异常类名:[{}],异常原因:[{}],异常发生所在类:[{}],异常发生所在方法名:[{}],异常发生所在代码行数:[{}]",
                    e.getClass().getName(), e.getMessage(), stackTrace[0].getClassName(), stackTrace[0].getMethodName(), stackTrace[0].getLineNumber());
        }
        return new CommonResult<String>(commonResultStatusEnum.code, message);
    }

}
