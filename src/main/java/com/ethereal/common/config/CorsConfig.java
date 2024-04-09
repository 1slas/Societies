package com.ethereal.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置类，用于通过Spring配置方式启用并定制跨域请求过滤器。
 *
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 跨域配置
 * @date 2024/3/24 18:14:11
 **/
@Configuration
public class CorsConfig {
    /**
     * 创建并配置CorsFilter Bean。
     *
     * @return CorsFilter 跨域请求过滤器实例
     */
    @Bean(name ="CorsConfig")
    public CorsFilter corsConfig(){
        // 创建基于URL的跨域配置源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 创建并配置跨域配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许所有来源访问
        corsConfiguration.addAllowedOrigin("*");
        // 允许所有请求头
        corsConfiguration.addAllowedHeader("*");
        // 允许所有请求方法
        corsConfiguration.addAllowedMethod("*");
        // 将跨域配置应用到所有路径
        source.registerCorsConfiguration("/**", corsConfiguration);
        // 返回CorsFilter实例
        return new CorsFilter(source);
    }
}
