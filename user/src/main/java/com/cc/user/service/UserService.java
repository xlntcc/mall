package com.cc.user.service;

import com.xx.cc.entities.UserCreateDTO;

/**
 * 用户服务接口
 * 定义用户相关的业务方法
 */
public interface UserService {

    /**
     * 创建用户
     * 
     * 将用户创建请求保存到数据库
     * 
     * @param createDTO 用户创建数据传输对象，包含用户名、密码、昵称、手机号、邮箱等信息
     */
    void createUser(UserCreateDTO createDTO);
}
