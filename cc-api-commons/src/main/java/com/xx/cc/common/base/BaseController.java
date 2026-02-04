package com.xx.cc.common.base;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xx.cc.common.exception.BusinessException;
import com.xx.cc.common.result.PageResult;
import com.xx.cc.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller基类
 * 提供通用的分页查询、参数校验、获取当前用户等常用方法
 * 所有业务Controller可继承此类以简化开发
 */
public abstract class BaseController {

    /**
     * 自动注入HttpServletRequest，用于获取请求信息
     */
    @Autowired
    protected HttpServletRequest request;

    /**
     * 将MyBatis-Plus分页对象转换为统一的分页结果对象
     * @param page MyBatis-Plus分页对象
     * @param <T> 数据类型
     * @return 统一分页结果对象
     */
    protected <T> PageResult<T> getPageResult(IPage<T> page) {
        return PageResult.of(page.getTotal(), (int) page.getCurrent(), (int) page.getSize(), page.getRecords());
    }

    /**
     * 创建分页对象，自动处理分页参数
     * @param pageNum 页码，默认第1页
     * @param pageSize 每页大小，默认10条
     * @return MyBatis-Plus分页对象
     */
    protected <T> Page<T> getPage(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        return new Page<>(pageNum, pageSize);
    }

    /**
     * 创建查询条件对象（Lambda风格，避免硬编码字段名）
     * @return LambdaQueryWrapper查询条件对象
     */
    protected LambdaQueryWrapper<Object> getQueryWrapper() {
        return new LambdaQueryWrapper<>();
    }

    /**
     * 创建更新条件对象（Lambda风格，避免硬编码字段名）
     * @return LambdaUpdateWrapper更新条件对象
     */
    protected LambdaUpdateWrapper<Object> getUpdateWrapper() {
        return new LambdaUpdateWrapper<>();
    }

    /**
     * 从请求头中获取当前登录用户的ID
     * @return 用户ID，未登录返回null
     */
    protected String getCurrentUserId() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getRequest().getHeader("X-User-Id");
        }
        return null;
    }

    /**
     * 条件满足时抛出业务异常（便捷方法）
     * @param condition 条件，true表示需要抛出异常
     * @param message 异常消息
     */
    protected void throwIf(boolean condition, String message) {
        if (condition) {
            throw new BusinessException(message);
        }
    }

    /**
     * 条件满足时抛出指定异常（便捷方法）
     * @param condition 条件，true表示需要抛出异常
     * @param exception 要抛出的异常对象
     */
    protected void throwIf(boolean condition, RuntimeException exception) {
        if (condition) {
            throw exception;
        }
    }
}
