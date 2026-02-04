package com.cc.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 用户实体类
 * 对应数据库表：user_info
 */
@TableName("user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 用户ID（主键）
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户姓名
     */
    @TableField("name")
    private String name;

    /**
     * 用户地址
     */
    @TableField("address")
    private String address;

    /**
     * 性别：0-未知，1-男，2-女
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 密码
     */
    @TableField("pass_word")
    private String passWord;

    /**
     * 逻辑删除标识：0-未删除，1-已删除
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 租户ID（用于多租户场景）
     */
    @TableField("tenant_id")
    private Long tenantId;

    /**
     * 创建人ID
     */
    @TableField("create_id")
    private Long createId;

    /**
     * 创建人姓名
     */
    @TableField("create_name")
    private String createName;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Timestamp createTime;

    /**
     * 更新人ID
     */
    @TableField("update_id")
    private Long updateId;

    /**
     * 更新人姓名
     */
    @TableField("update_name")
    private String updateName;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Timestamp updateTime;
}
