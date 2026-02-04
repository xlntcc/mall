package com.xx.cc.common.feign;

import lombok.Data;
import java.io.Serializable;

/**
 * 用户数据传输对象
 * 用于Feign远程调用时传递用户信息
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;
}
