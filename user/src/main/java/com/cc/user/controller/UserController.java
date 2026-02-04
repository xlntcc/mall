package com.cc.user.controller;

import com.cc.user.service.UserService;
import com.xx.cc.entities.UserCreateDTO;
import com.xx.cc.common.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * 处理用户相关的HTTP请求
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    /**
     * 用户服务
     */
    private final UserService userService;

    /**
     * 创建用户
     * 
     * 接口地址：POST /user/create
     * 请求体：UserCreateDTO（包含username、password、nickname、phone、email）
     * 
     * @param createDTO 用户创建数据传输对象
     * @return 统一响应结果
     */
    @PostMapping("/user/create")
    public Result<String> createUser(@RequestBody UserCreateDTO createDTO) {
        userService.createUser(createDTO);
        return Result.success("创建成功！");
    }
}
