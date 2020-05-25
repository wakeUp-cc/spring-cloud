package com.cc.common.result;

import lombok.Data;

/**
 * @author 池臣
 * @data 2020/5/25
 */
@Data
public class CommonResult<T> {

    /**
     * 状态
     *
     * @see CommonResultStatus
     */
    private CommonResultStatus status = CommonResultStatus.FAILURE;

    /**
     * 返回的结果
     */
    private T result;

    public boolean getStatus() {
        return status.code;
    }
}
