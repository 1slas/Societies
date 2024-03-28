package com.ethereal.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 跨域配置
 * @date 2024/3/24 18:14:11
 **/
@Configuration
public class CorsConfig {
    @Bean(name ="CorsConfig" )
    public CorsFilter corsConfig(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        //1.设置访问源 地址
        corsConfiguration.addAllowedHeader("*");
        //2.设置访问源 请求头
        corsConfiguration.addAllowedMethod("*");
        //3.设置访问源 请求方法
        source.registerCorsConfiguration("/**",corsConfiguration);
        //4.对接口配置的 跨域设置
        return new CorsFilter(source);
    }
}
