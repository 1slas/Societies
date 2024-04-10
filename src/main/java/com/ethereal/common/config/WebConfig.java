package com.ethereal.common.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置类，用于定制Spring MVC的配置，例如拦截器的设置。
 *
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description Web配置类，实现WebMvcConfigurer接口用于自定义Spring MVC配置。
 * @date 2024/3/24 18:59:56
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private JwtInterceptor jwtInterceptor; // 用于注入JwtInterceptor实例，进行权限校验。

    /**
     * 配置拦截器，添加自定义拦截器JwtInterceptor，并设置拦截规则。
     * 拦截所有请求，但排除了一些不需要拦截的路径，如登录、注册等。
     *
     * @param registry 拦截器注册器，用于添加和配置拦截器。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/") // 排除根路径
                .excludePathPatterns("/login") // 排除登录路径
                .excludePathPatterns("/register") // 排除注册路径
                .excludePathPatterns("/file/**"); // 排除文件路径
    }
}
