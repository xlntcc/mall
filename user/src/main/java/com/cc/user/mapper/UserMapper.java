package com.cc.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.user.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户数据访问接口
 * 继承MyBatis-Plus提供的BaseMapper，获得基本的数据库操作能力
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 继承BaseMapper后，自动拥有以下方法：
    // insert(T entity) - 插入数据
    // deleteById(Serializable id) - 根据ID删除
    // updateById(T entity) - 根据ID更新
    // selectById(Serializable id) - 根据ID查询
    // selectList(wrapper) - 条件查询列表
    // selectPage(page, wrapper) - 条件分页查询
    // 等等...
}
