package com.cc.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.cc.user.mapper.UserMapper;
import com.cc.user.model.User;
import com.cc.user.service.UserService;
import com.xx.cc.entities.UserCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 * 实现UserService接口中定义的所有业务方法
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    /**
     * 用户数据访问接口
     */
    private final UserMapper userMapper;

    /**
     * 创建用户
     * 将DTO对象转换为实体对象并保存到数据库
     * 
     * @param createDTO 用户创建数据传输对象
     */
    @Override
    public void createUser(UserCreateDTO createDTO) {
        // 使用Hutool工具将DTO转换为实体对象
        User user = BeanUtil.copyProperties(createDTO, User.class);
        // 调用Mapper将用户数据插入数据库
        userMapper.insert(user);
    }
}
