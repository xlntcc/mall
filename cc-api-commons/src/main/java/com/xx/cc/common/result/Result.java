package com.xx.cc.common.result;

import com.xx.cc.common.enums.ResultCode;
import lombok.Data;
import java.io.Serializable;

/**
 * 统一响应结果封装类
 * 用于Controller层返回统一的响应格式，与ResultData功能类似，提供另一种响应封装方式
 * 
 * @param <T> 响应数据的泛型类型
 */
@Data
public class Result<T> implements Serializable {
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
     * 默认构造函数，自动生成时间戳
     */
    public Result() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 构造函数，指定状态码和消息
     * @param code 状态码
     * @param message 消息
     */
    public Result(Integer code, String message) {
        this();
        this.code = code;
        this.message = message;
    }

    /**
     * 构造函数，指定状态码、消息和数据
     * @param code 状态码
     * @param message 消息
     * @param data 响应数据
     */
    public Result(Integer code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    /**
     * 创建成功响应（无数据）
     * @param <T> 泛型类型
     * @return 成功响应对象
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    /**
     * 创建成功响应（带数据）
     * @param data 响应数据
     * @param <T> 泛型类型
     * @return 成功响应对象
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 创建成功响应（自定义状态码、消息和数据）
     * @param code 自定义状态码
     * @param message 自定义消息
     * @param data 响应数据
     * @param <T> 泛型类型
     * @return 成功响应对象
     */
    public static <T> Result<T> success(Integer code, String message, T data) {
        return new Result<>(code, message, data);
    }

    /**
     * 创建失败响应（自定义消息）
     * @param message 失败消息
     * @param <T> 泛型类型
     * @return 失败响应对象
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(ResultCode.FAIL.getCode(), message);
    }

    /**
     * 创建失败响应（自定义状态码和消息）
     * @param code 状态码
     * @param message 失败消息
     * @param <T> 泛型类型
     * @return 失败响应对象
     */
    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<>(code, message);
    }

    /**
     * 创建失败响应（使用预定义的状态码枚举）
     * @param resultCode 状态码枚举
     * @param <T> 泛型类型
     * @return 失败响应对象
     */
    public static <T> Result<T> fail(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage());
    }

    /**
     * 创建失败响应（使用预定义的状态码枚举，并自定义消息）
     * @param resultCode 状态码枚举
     * @param message 自定义消息
     * @param <T> 泛型类型
     * @return 失败响应对象
     */
    public static <T> Result<T> fail(ResultCode resultCode, String message) {
        return new Result<>(resultCode.getCode(), message);
    }

    /**
     * 判断响应是否成功
     * @return true-成功，false-失败
     */
    public boolean isSuccess() {
        return ResultCode.SUCCESS.getCode().equals(this.code);
    }
}
