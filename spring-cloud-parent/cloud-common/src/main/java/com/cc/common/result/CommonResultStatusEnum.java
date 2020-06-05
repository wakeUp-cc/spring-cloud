package com.cc.common.result;

/**
 * @author 池臣
 * @data 2020/5/25
 * 成功/失败
 */
public enum CommonResultStatusEnum {

    /**
     * 成功
     */
    SUCCESS(1, "成功"),
    /**
     * 失败
     */
    FAILURE(2, "失败");

    public Integer code;
    public String name;

    CommonResultStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
