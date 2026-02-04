package com.xx.cc.common.feign.fallback;

import com.xx.cc.common.enums.ResultCode;
import com.xx.cc.common.feign.UserDTO;
import com.xx.cc.common.feign.UserFeignClient;
import com.xx.cc.common.result.Result;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFeignClientFallback implements UserFeignClient {

    /**
     * UserFeignClient的降级实现类
     * 当用户服务调用失败时，返回服务不可用的默认响应
     */
    @Override
    public Result<UserDTO> getUserById(Long id, String userId) {
        return Result.fail(ResultCode.SERVICE_UNAVAILABLE, "用户服务不可用");
    }

    /**
     * 根据用户ID列表批量获取用户信息
     * 当服务不可用时返回降级响应
     */
    @Override
    public Result<List<UserDTO>> getUsersByIds(List<Long> ids) {
        return Result.fail(ResultCode.SERVICE_UNAVAILABLE, "用户服务不可用");
    }

    /**
     * 获取当前登录用户信息
     * 当服务不可用时返回降级响应
     */
    @Override
    public Result<UserDTO> getCurrentUser(String userId) {
        return Result.fail(ResultCode.SERVICE_UNAVAILABLE, "用户服务不可用");
    }
}
