package com.cc.common.result;

/**
 * @author 池臣
 * @data 2020/5/25
 * 成功/失败
 */
public enum CommonResultStatus {

    /**
     * 成功
     */
    SUCCESS(true, "成功"),
    /**
     * 失败
     */
    FAILURE(false, "失败");

    public boolean code;
    public String name;

    CommonResultStatus(boolean code, String name) {
        this.code = code;
        this.name = name;
    }
}
