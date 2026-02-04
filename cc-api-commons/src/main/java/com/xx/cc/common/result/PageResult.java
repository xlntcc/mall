package com.xx.cc.common.result;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装类
 * 用于返回分页查询的统一格式
 * 
 * @param <T> 分页数据的泛型类型
 */
@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 当前页的数据列表
     */
    private List<T> list;

    /**
     * 默认构造函数
     */
    public PageResult() {}

    /**
     * 构造函数
     * @param total 总记录数
     * @param pageNum 当前页码
     * @param pageSize 每页大小
     * @param list 当前页数据列表
     */
    public PageResult(Long total, Integer pageNum, Integer pageSize, List<T> list) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.list = list;
        // 计算总页数
        this.totalPages = (int) Math.ceil((double) total / pageSize);
    }

    /**
     * 静态工厂方法创建分页结果
     * @param total 总记录数
     * @param pageNum 当前页码
     * @param pageSize 每页大小
     * @param list 当前页数据列表
     * @param <T> 泛型类型
     * @return 分页结果对象
     */
    public static <T> PageResult<T> of(Long total, Integer pageNum, Integer pageSize, List<T> list) {
        return new PageResult<>(total, pageNum, pageSize, list);
    }
}
