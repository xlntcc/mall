package com.xx.cc.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应状态码枚举
 * 定义系统中使用的所有响应状态码，便于统一管理和维护
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    // ============ 通用状态码 ============
    
    /**
     * 请求成功
     */
    SUCCESS(200, "操作成功"),
    
    /**
     * 请求失败
     */
    FAIL(500, "操作失败"),

    // ============ 客户端错误状态码 ============
    
    /**
     * 参数错误
     */
    PARAM_ERROR(400, "参数错误"),
    
    /**
     * 未授权（未登录或token已过期）
     */
    UNAUTHORIZED(401, "未登录或token已过期"),
    
    /**
     * 禁止访问（没有操作权限）
     */
    FORBIDDEN(403, "没有操作权限"),
    
    /**
     * 资源不存在
     */
    NOT_FOUND(404, "资源不存在"),

    // ============ 服务端错误状态码 ============
    
    /**
     * 服务器内部错误
     */
    SERVER_ERROR(1000, "服务器内部错误"),
    
    /**
     * 服务不可用（通常用于服务降级或熔断）
     */
    SERVICE_UNAVAILABLE(1001, "服务不可用"),

    // ============ 用户相关错误码 ============
    
    /**
     * 用户不存在
     */
    USER_NOT_FOUND(2001, "用户不存在"),
    
    /**
     * 密码错误
     */
    USER_PASSWORD_ERROR(2002, "密码错误"),
    
    /**
     * 用户已存在
     */
    USER_EXISTS(2003, "用户已存在"),

    // ============ 订单相关错误码 ============
    
    /**
     * 订单不存在
     */
    ORDER_NOT_FOUND(3001, "订单不存在"),
    
    /**
     * 订单状态异常
     */
    ORDER_STATUS_ERROR(3002, "订单状态异常"),

    // ============ 商品相关错误码 ============
    
    /**
     * 商品不存在
     */
    PRODUCT_NOT_FOUND(4001, "商品不存在"),
    
    /**
     * 商品库存不足
     */
    PRODUCT_STOCK_NOT_ENOUGH(4002, "商品库存不足");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 状态描述信息
     */
    private final String message;
}
