package com.xx.cc.common.feign;

import com.xx.cc.common.result.Result;
import com.xx.cc.common.feign.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * 用户服务Feign客户端接口
 * 用于远程调用用户服务的REST API
 * 
 * @see UserFeignClientFallback 服务降级实现类
 */
@FeignClient(name = "cc-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    /**
     * 根据ID获取用户信息
     * @param id 用户ID
     * @param userId 请求头中的用户ID
     * @return 用户信息响应
     */
    @GetMapping("/api/user/{id}")
    Result<UserDTO> getUserById(@PathVariable("id") Long id,
                                @RequestHeader(value = "X-User-Id", required = false) String userId);

    /**
     * 批量根据ID列表获取用户信息
     * @param ids 用户ID列表
     * @return 用户信息列表响应
     */
    @GetMapping("/api/user/batch")
    Result<List<UserDTO>> getUsersByIds(List<Long> ids);

    /**
     * 获取当前登录用户信息
     * @param userId 请求头中的用户ID
     * @return 当前用户信息响应
     */
    @GetMapping("/api/user/info")
    Result<UserDTO> getCurrentUser(@RequestHeader(value = "X-User-Id") String userId);
}
