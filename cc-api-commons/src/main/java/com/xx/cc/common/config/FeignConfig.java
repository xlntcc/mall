package com.xx.cc.common.config;

import com.xx.cc.common.constant.Constants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Feign配置类
 * 配置Feign请求拦截器，实现服务间调用的请求头传递
 */
@Configuration
public class FeignConfig {

    /**
     * 配置Feign请求拦截器
     * 用于在Feign调用时自动传递原始请求的Header信息
     * @return RequestInterceptor实例
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }

    /**
     * Feign请求拦截器实现类
     * 从当前请求上下文中获取Header信息，并添加到Feign请求中
     */
    public static class FeignRequestInterceptor implements RequestInterceptor {

        /**
         * 对Feign请求进行预处理
         * 提取原始请求的Token、UserId、UserName等Header并传递到下游服务
         * 
         * @param template Feign请求模板
         */
        @Override
        public void apply(RequestTemplate template) {
            // 获取当前请求的上下文
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                
                // 传递Authorization Token
                String token = request.getHeader(Constants.TOKEN_HEADER);
                if (token != null && !token.isEmpty()) {
                    template.header(Constants.TOKEN_HEADER, token);
                }
                
                // 传递用户ID
                String userId = request.getHeader(Constants.USER_ID_HEADER);
                if (userId != null) {
                    template.header(Constants.USER_ID_HEADER, userId);
                }
                
                // 传递用户名
                String userName = request.getHeader(Constants.USER_NAME_HEADER);
                if (userName != null) {
                    template.header(Constants.USER_NAME_HEADER, userName);
                }
            }
        }
    }
}
