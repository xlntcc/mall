package com.xx.cc.resp;

import com.xx.cc.common.enums.ResultCode;
import lombok.Data;
import java.io.Serializable;

/**
 * 统一响应数据封装类
 * 用于API接口返回统一的响应格式
 */
@Data
public class ResultData<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 响应状态码
     */
    private Integer code;
    
    /**
     * 响应消息
     */
    private String message;
    
    /**
     * 响应数据
     */
    private T data;
    
    /**
     * 响应时间戳
     */
    private Long timestamp;

    /**
     * 无参构造函数，自动生成时间戳
     */
    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 有参构造函数
     * @param code 状态码
     * @param message 消息
     */
    public ResultData(Integer code, String message) {
        this();
        this.code = code;
        this.message = message;
    }

    /**
     * 有参构造函数
     * @param code 状态码
     * @param message 消息
     * @param data 数据
     */
    public ResultData(Integer code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    /**
     * 成功响应（无数据）
     * @return 成功响应对象
     */
    public static <T> ResultData<T> success() {
        return new ResultData<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    /**
     * 成功响应（带数据）
     * @param data 返回的数据
     * @return 成功响应对象
     */
    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功响应（自定义消息和数据）
     * @param message 自定义消息
     * @param data 返回的数据
     * @return 成功响应对象
     */
    public static <T> ResultData<T> success(String message, T data) {
        return new ResultData<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败响应（自定义消息）
     * @param message 失败消息
     * @return 失败响应对象
     */
    public static <T> ResultData<T> fail(String message) {
        return new ResultData<>(ResultCode.FAIL.getCode(), message);
    }

    /**
     * 失败响应（自定义状态码和消息）
     * @param code 状态码
     * @param message 失败消息
     * @return 失败响应对象
     */
    public static <T> ResultData<T> fail(Integer code, String message) {
        return new ResultData<>(code, message);
    }

    /**
     * 失败响应（使用预定义的状态码枚举）
     * @param resultCode 状态码枚举
     * @return 失败响应对象
     */
    public static <T> ResultData<T> fail(ResultCode resultCode) {
        return new ResultData<>(resultCode.getCode(), resultCode.getMessage());
    }

    /**
     * 失败响应（使用预定义的状态码枚举，并自定义消息）
     * @param resultCode 状态码枚举
     * @param message 自定义消息
     * @return 失败响应对象
     */
    public static <T> ResultData<T> fail(ResultCode resultCode, String message) {
        return new ResultData<>(resultCode.getCode(), message);
    }

    /**
     * 判断是否成功
     * @return true-成功，false-失败
     */
    public boolean isSuccess() {
        return ResultCode.SUCCESS.getCode().equals(this.code);
    }
}
