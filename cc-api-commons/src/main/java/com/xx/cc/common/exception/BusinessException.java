package com.xx.cc.common.exception;

import com.xx.cc.common.enums.ResultCode;
import lombok.Getter;

/**
 * 业务异常类
 * 用于抛出业务逻辑相关的异常，可携带自定义错误码和错误信息
 */
@Getter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误信息
     */
    private final String message;

    /**
     * 构造函数，使用默认错误码（FAIL=500）
     * @param message 错误信息
     */
    public BusinessException(String message) {
        super(message);
        this.code = ResultCode.FAIL.getCode();
        this.message = message;
    }

    /**
     * 构造函数，指定错误码和错误信息
     * @param code 错误码
     * @param message 错误信息
     */
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 构造函数，使用预定义的ResultCode枚举
     * @param resultCode 状态码枚举
     */
    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    /**
     * 构造函数，使用预定义的ResultCode枚举，并自定义错误信息
     * @param resultCode 状态码枚举
     * @param message 自定义错误信息
     */
    public BusinessException(ResultCode resultCode, String message) {
        super(message);
        this.code = resultCode.getCode();
        this.message = message;
    }
}
