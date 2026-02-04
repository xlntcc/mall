package com.xx.cc.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Jackson配置类
 * 配置JSON序列化的相关参数
 */
@Configuration
public class JacksonConfig {

    /**
     * 配置ObjectMapper
     * 1. 注册Java8时间模块，支持LocalDateTime序列化
     * 2. 禁用将日期写为时间戳格式，改为ISO-8601格式
     * 
     * @return 配置好的ObjectMapper
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // 注册Java8时间模块
        mapper.registerModule(new JavaTimeModule());
        // 禁用将日期写为时间戳，启用ISO-8601格式
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }
}
