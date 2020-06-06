package com.cc.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 池臣
 * @data 2020/5/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    /**
     * 状态
     *
     * @see CommonResultStatusEnum
     */
    private int status;

    /**
     * 返回的结果
     */
    private T result;

}
