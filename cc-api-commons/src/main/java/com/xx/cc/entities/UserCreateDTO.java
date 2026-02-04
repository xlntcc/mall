package com.xx.cc.entities;

import lombok.Data;
import java.io.Serializable;

/**
 * 用户创建数据传输对象
 * 用于接收创建用户请求时的参数
 */
@Data
public class UserCreateDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
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
