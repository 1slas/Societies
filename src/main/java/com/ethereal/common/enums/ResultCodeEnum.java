package com.ethereal.common.enums;

/**
 * 封装类状态码的枚举
 * 该枚举定义了系统中各种操作的结果状态码，以及对应的状态信息。
 * 每个枚举值代表一个特定的操作结果，包含操作结果的状态码（code）和信息（msg）。
 *
 * @author Echo
 * @version 1.0
 * @project Societies
 * @date 2024/3/23 14:34:05
 **/
public enum ResultCodeEnum {

    // 操作成功
    SUCCESS("200","成功"),
    // 参数异常
    PARAM_ERROR("400","参数异常"),
    // 无效的token
    TOKEN_INVALID_ERROR("401","无效的token"),
    // token验证失败，请重新登录
    TOKEN_CHECK_ERROR("401","token验证失败，请重新登录"),
    // 参数缺失
    PARAM_LOST_ERROR("4001","参数缺失"),
    // 系统异常
    SYSTEM_ERROR("500","系统异常"),
    // 用户名已存在
    USER_EXIST_ERROR("5001","用户名已存在"),
    // 用户未登录
    USER_NOT_LOGIN("5002","用户未登录"),
    // 账号密码错误
    USER_ACCOUNT_ERROR("5003","账号密码错误"),
    // 用户不存在
    USER_NOT_EXIST_ERROR("5004","用户不存在"),
    // 原密码输入错误
    PARAM_PASSWORD_ERROR("5005","原密码输入错误"),
    // 用户已经担任其他社团社长
    HEADER_ALREADY_ERROR("5006", "该用户已经担任其他社团社长了"),
    // 已经申请过该社团
    APPLY_ALREADY_ERROR("5007", "您已经申请过该社团"),


    ;

    public String code; // 状态码
    public String msg; // 相关信息

    /**
     * 构造函数，用于初始化每个枚举值的状态码和信息。
     *
     * @param code 操作结果的状态码
     * @param msg 操作结果的信息
     */
    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
