package com.xx.cc.common.constant;

/**
 * 系统常量定义类
 * 包含Token、请求头等常用常量的统一管理
 */
public class Constants {

    /**
     * Authorization请求头名称
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * Bearer Token前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 用户ID请求头名称
     */
    public static final String USER_ID_HEADER = "X-User-Id";

    /**
     * 用户名请求头名称
     */
    public static final String USER_NAME_HEADER = "X-User-Name";

    /**
     * 服务名请求头名称
     */
    public static final String SERVICE_NAME_HEADER = "X-Service-Name";

    /**
     * Token过期时间（毫秒），默认24小时
     */
    public static final Long TOKEN_EXPIRE_TIME = 24 * 60 * 60 * 1000L;

    /**
     * 私有构造函数，防止实例化
     */
    private Constants() {}
}
