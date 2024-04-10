package com.ethereal.common.config;

import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ethereal.common.Constants;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.exception.CustomException;
import com.ethereal.pojo.Account;
import com.ethereal.service.AdminService;
import com.ethereal.service.UserService;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * JWT拦截器，用于对HTTP请求进行认证和授权验证。
 *
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 用于在请求处理前验证JWT Token的有效性。
 * @date 2024/3/24 18:26:13
 **/
@Component
public class JwtInterceptor implements HandlerInterceptor {
    static {
        LoggerFactory.getLogger(JwtInterceptor.class);
    }

    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;

    /**
     * 在请求处理前执行的预处理方法。
     * 主要用于JWT Token的验证。
     *
     * @param request  HttpServletRequest对象，代表客户端的HTTP请求。
     * @param response HttpServletResponse对象，用于向客户端发送响应。
     * @param handler  将要执行的处理器对象。
     * @return boolean 如果验证通过，返回true，继续处理请求；否则，返回false，中断请求处理。
     * @throws CustomException 如果验证过程中出现异常，抛出自定义异常。
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, @Nonnull HttpServletResponse response,@Nonnull Object handler)   {
        // 从请求头或参数中获取Token
        String token = request.getHeader(Constants.TOKEN);
        if (ObjectUtils.isEmpty(token)){
            token = request.getParameter(Constants.TOKEN);
        }

        // 验证Token的存在性
        if(ObjectUtils.isEmpty(token)){
            throw new CustomException(ResultCodeEnum.TOKEN_INVALID_ERROR);
        }

        Account account = null;
        try {
            // 解析Token，获取用户信息
            String userRole = JWT.decode(token).getAudience().get(0);
                String userId = userRole.split("-")[0];
            String role = userRole.split("-")[1];

            // 根据用户角色查询用户信息
            if (RoleEnum.ADMIN.name().equals(role)){
                account = adminService.selectById(Integer.valueOf(userId));
            }
            if (RoleEnum.USER.name().equals(role)){
                account = userService.selectById(Integer.valueOf(userId));
            }
        }catch (Exception e){
            throw new CustomException(ResultCodeEnum.TOKEN_CHECK_ERROR);
        }

        // 验证用户信息的存在性
        if (ObjectUtil.isNull(account)){
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }

        try {
            // 使用用户密码验证Token的有效性
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(account.getPassword())).build();
            jwtVerifier.verify(token);
        }catch(JWTVerificationException e){

            throw new CustomException(ResultCodeEnum.TOKEN_CHECK_ERROR);
        }

        return true;
    }
}
