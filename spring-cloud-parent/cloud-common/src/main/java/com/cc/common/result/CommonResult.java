package com.cc.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 池臣
 * @data 2020/5/25
 */
@Data
@AllArgsConstructor
public class CommonResult<T> {

    /**
     * 状态
     *
     * @see CommonResultStatusEnum
     */
    private CommonResultStatusEnum status;

    /**
     * 返回的结果
     */
    private T result;

    public Integer getStatus() {
        return status.code;
    }
}
