package com.ethereal.common.enums;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 封装类状态码的枚举
 * @date 2024/3/23 14:34:05
 **/

public enum ResultCodeEnum {

    SUCCESS("200","成功"),
    PARAM_ERROR("400","参数异常"),
    TOKEN_INVALID_ERROR("401","无效的token"),
    TOKEN_CHECK_ERROR("401","token验证失败，请重新登录"),
    PARAM_LOST_ERROR("4001","参数缺失"),

    SYSTEM_ERROR("500","系统异常"),
    USER_EXIST_ERROR("5001","用户名已存在"),
    USER_NOT_LOGIN("5002","用户为登录"),
    USER_ACCOUNT_ERROR("5003","账号密码错误"),
    USER_NOT_EXIST_ERROR("5004","用户不存在"),
    PARAM_PASSWORD_ERROR("5005","原密码输入错误"),
    HEADER_ALREADY_ERROR("5006", "该用户已经担任其他社团社长了"),
    APPLY_ALREADY_ERROR("5007", "您已经申请过该社团"),


    ;

    public String code;
    public String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
