package com.cc.common.entity;

/**
 * @author 池臣
 * @data 2020/5/25
 * restful请求响应编码
 */
public enum CommonResultStatusEnum {

    /**
     * 获取数据成功,适用于GET请求
     */
    GET_SUCCESS(200, "请求数据成功"),
    /**
     * 新增/修改数据成功,适用于POST/PUT请求
     */
    PUT_SUCCESS(201, "操作数据成功"),
    /**
     * 请求提交到后台队列进行排队(异步任务)
     */
    ASYNCHRONOUS_SUCCESS(202, "请求提交后台排队成功"),
    /**
     * 删除数据成功,适用于DELETE请求
     */
    DELETE_SUCCESS(204, "删除数据成功"),
    /**
     * 没有权限请求失败(令牌,用户名,密码错误)
     */
    NO_PERMISSION_ERROR(401, "无权限请求"),
    /**
     * 有权限操作,但是访问被禁止
     */
    FORBIDDEN_ERROR(403, "访问被禁止"),
    /**
     * 用户的请求针对的是不存在的记录
     */
    NOT_FOUND_ERROR(404, "请求资源不存在"),
    /**
     * 用户的请求格式错误
     */
    FORMAT_ERROR(406, "请求格式错误"),
    /**
     * 用户请求的资源被永久删除，且不会再得到的
     */
    GONE_ERROR(410, "请求的资源被永久删除"),
    /**
     * 创建一个对象的时候,验证错误
     */
    VERIFICATION_ERROR(422, "创建对象验证错误"),
    /**
     * 服务器发生错误,请求结果未知
     */
    ERROR(500, "系统发生未知错误,请与及时管理员联系");
    /**
     * 编码
     */
    public Integer code;
    /**
     * 信息
     */
    public String message;

    CommonResultStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
