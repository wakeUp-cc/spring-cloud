package com.cc.common.unifiedexceptionhandling;

import com.cc.common.exceptions.MessageException;
import com.cc.common.result.CommonResult;
import com.cc.common.result.CommonResultStatus;
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
        if (e instanceof MessageException) {
            message = e.getMessage();
        } else if (e instanceof ConstraintViolationException) {
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
            message = "系统发生异常,请及时与管理员联系";
            StackTraceElement[] stackTrace = e.getStackTrace();
            log.error("系统发生异常,异常原因:" + e.getMessage()
                    + ",异常发生的类名:[" + stackTrace[0].getClassName()
                    + "],异常发生的方法名:[" + stackTrace[0].getMethodName()
                    + "],异常发生的代码行数:[" + stackTrace[0].getLineNumber() + "].");
        }
        return new CommonResult<>(CommonResultStatus.FAILURE, message);
    }

}
