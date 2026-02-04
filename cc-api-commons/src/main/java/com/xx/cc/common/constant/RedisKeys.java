package com.xx.cc.common.constant;

/**
 * Redis缓存键常量定义类
 * 统一管理项目中使用的Redis key前缀，避免硬编码，便于维护
 */
public class RedisKeys {

    /**
     * 缓存前缀标识
     */
    public static final String CACHE_PREFIX = "mall:";

    /**
     * 用户缓存前缀
     */
    public static final String USER_CACHE_PREFIX = CACHE_PREFIX + "user:";

    /**
     * 商品缓存前缀
     */
    public static final String PRODUCT_CACHE_PREFIX = CACHE_PREFIX + "product:";

    /**
     * 订单缓存前缀
     */
    public static final String ORDER_CACHE_PREFIX = CACHE_PREFIX + "order:";

    /**
     * 获取用户缓存键
     * @param userId 用户ID
     * @return 完整的用户缓存键
     */
    public static String getUserKey(Long userId) {
        return USER_CACHE_PREFIX + userId;
    }

    /**
     * 获取商品缓存键
     * @param productId 商品ID
     * @return 完整的商品缓存键
     */
    public static String getProductKey(Long productId) {
        return PRODUCT_CACHE_PREFIX + productId;
    }

    /**
     * 获取订单缓存键
     * @param orderId 订单ID
     * @return 完整的订单缓存键
     */
    public static String getOrderKey(Long orderId) {
        return ORDER_CACHE_PREFIX + orderId;
    }

    /**
     * 私有构造函数，防止实例化
     */
    private RedisKeys() {}
}
