package com.cc.common.exceptions;

/**
 * @author 池臣
 * @data 2020/5/27
 * 携带消息到前端的异常类
 */
public class MessageException extends Exception {

    public MessageException(String message) {
        super(message);
    }

}
