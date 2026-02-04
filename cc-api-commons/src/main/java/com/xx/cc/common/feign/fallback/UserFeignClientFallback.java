package com.xx.cc.common.feign.fallback;

import com.xx.cc.common.enums.ResultCode;
import com.xx.cc.common.feign.UserDTO;
import com.xx.cc.common.feign.UserFeignClient;
import com.xx.cc.common.result.Result;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public Result<UserDTO> getUserById(Long id, String userId) {
        return Result.fail(ResultCode.SERVICE_UNAVAILABLE, "用户服务不可用");
    }

    @Override
    public Result<List<UserDTO>> getUsersByIds(List<Long> ids) {
        return Result.fail(ResultCode.SERVICE_UNAVAILABLE, "用户服务不可用");
    }

    @Override
    public Result<UserDTO> getCurrentUser(String userId) {
        return Result.fail(ResultCode.SERVICE_UNAVAILABLE, "用户服务不可用");
    }
}
