package com.ethereal.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.ethereal.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description
 * @date 2024/3/24 20:36:43
 **/
@ControllerAdvice(basePackages = "com.ethereal.controller" )
public class GlobalExceptionHandler {
    private static final Log log = LogFactory.get();

    //统一异常处理@ExceptionHandler 主要用于Exception
    // 返回json串
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(HttpServletRequest request,Exception e){
        log.error("异常信息：",e);
        return Result.error();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result customError(HttpServletRequest request, CustomException e){
        return Result.error(e.getCode(), e.getMsg());
    }

}
