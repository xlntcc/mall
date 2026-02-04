package com.cc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 用户服务启动类
 * 
 * 启用功能：
 * 1. Spring Boot自动配置
 * 2. Nacos服务注册与发现（EnableDiscoveryClient）
 * 3. Nacos配置中心动态刷新（RefreshScope）
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class UserApplication {

    /**
     * 应用入口方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
