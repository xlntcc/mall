package com.cc.user.controller;

import com.cc.user.service.UserService;
import com.xx.cc.entities.UserCreateDTO;
import com.xx.cc.resp.ResultData;
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
    public ResultData<String> createUser(@RequestBody UserCreateDTO createDTO) {
        // 调用服务层创建用户
        userService.createUser(createDTO);
        // 返回成功响应
        return ResultData.success("创建成功！");
    }
}
