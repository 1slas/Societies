package com.ethereal.untils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.ethereal.common.Constants;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.pojo.Account;
import com.ethereal.service.AdminService;
import com.ethereal.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description Token工具类
 * @date 2024/3/23 15:19:12
 **/

public class Token {
    private static final Logger log = LoggerFactory.getLogger(Token.class);

    private static AdminService staticAdminService;
    private static UserService staticUserService;

    @Resource
    AdminService adminService;

    @Resource
    UserService userService;

    @PostConstruct
    public void setUserService(){
        staticAdminService = adminService;
        staticUserService = userService;
    }

    /**
     * 生成token
     */

    public static String creatToken(String data , String sign){
        return JWT.create().withAudience(data)
                .withExpiresAt(DateUtil.offsetHour(new Date(),2))
                        .sign(Algorithm.HMAC256(sign));
    }

    /**
     * 获取当前用户登录信息
     */
    public static Account getCurrentUser(){
        try {
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader(Constants.TOKEN);
            if(ObjectUtil.isNotEmpty(token)){
                String userRole = JWT.decode(token).getAudience().get(0);
                String userId = userRole.split("-")[0];
                String role = userRole.split("-")[1];
                if (RoleEnum.ADMIN.name().equals(role)) {
                    return staticAdminService.selectById(Integer.valueOf(userId));
                }
            }
        }catch (Exception e){
            log.error("获取用户信息出错" , e);
        }
        return new Account();
    }
}
