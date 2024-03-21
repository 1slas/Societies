package com.ethereal.common.config;

import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.ethereal.common.Constants;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.pojo.Account;
import com.ethereal.service.AdminService;
import com.ethereal.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description jwt拦截器
 * @date 2024/3/24 18:26:13
 **/

public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(JwtInterceptor.class);

    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)   {
        //1.从http中的header中获取token
        String token = request.getHeader(Constants.TOKEN);
        if (ObjectUtils.isEmpty(token)){
            //如果没有拿到 那就从参数中再拿一次
            token = request.getParameter(Constants.TOKEN);
        }
        //2.开始执行认证
        if(ObjectUtils.isEmpty(token)){
            throw new CustomException(ResultCodeEnum.TOKEN_INVALID_ERROR);
        }
        Account account = null;
        try {
            //解析token获取存储的数据
            String userRole = JWT.decode(token).getAudience().get(0);
            String userId = userRole.split("-")[0];
            String role = userRole.split("-")[1];
            //根据用户id查询数据库
            if (RoleEnum.ADMIN.name().equals(role)){
                account = adminService.selectById(Integer.valueOf(userId));
            }
            if (RoleEnum.USER.name().equals(role)){
                account = userService.selectById(Integer.valueOf(userId));
            }
        }catch (Exception e){
            throw new CustomException(ResultCodeEnum.TOKEN_CHECK_ERROR);
        }
        if (ObjectUtil.isNull(account)){
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        try {
            //用户密码 加签验证token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(account.getPassword())).build();
            //验证token
            jwtVerifier.verify(token);
        }catch(JWTVerificationException e){
            throw new CustomException(ResultCodeEnum.TOKEN_CHECK_ERROR);
        }
        return true;
    }
}
