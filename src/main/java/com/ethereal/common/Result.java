package com.ethereal.common;

import com.ethereal.common.enums.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 结果封装类，用于统一返回接口调用的结果信息。
 * 包含状态码（code）、消息（msg）和数据（data）三个主要字段。
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 统一封装类，用于返回操作结果
 * @date 2024/3/23 14:28:45
 **/
@Setter
@Getter
public class Result {
    // 设置状态码
    // 获取状态码
    private String code; // 状态码
    // 设置消息
    // 获取消息
    private String msg;  // 消息，用于描述操作结果的详细信息
    // 设置数据
    // 获取数据
    private Object data; // 数据，即接口调用返回的实际内容

    // 带数据的构造函数
    public Result(Object data) {
        this.data = data;
    }

    // 默认构造函数
    public Result() {
    }

    /**
     * 创建一个操作成功的Result对象。
     * @return Result 包含成功状态码和默认成功消息的结果对象
     **/
    public static Result success(){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS.code);
        result.setMsg(ResultCodeEnum.SUCCESS.msg);
        return result;
    }

    /**
     * 创建一个包含数据的成功Result对象。
     * @param data 返回的数据
     * @return Result 包含成功状态码、默认成功消息和数据的结果对象
     **/
    public static Result success(Object data){
        Result result = new Result(data);
        result.setCode(ResultCodeEnum.SUCCESS.code);
        result.setMsg(ResultCodeEnum.SUCCESS.msg);
        return result;
    }

    /**
     * 创建一个操作失败的Result对象。
     * @return Result 包含系统错误状态码和默认错误消息的结果对象
     **/
    public static Result error(){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SYSTEM_ERROR.code);
        result.setMsg(ResultCodeEnum.SYSTEM_ERROR.msg);
        return result;
    }

    /**
     * 创建一个包含数据的错误Result对象。
     * @param data 返回的数据
     * @return Result 包含系统错误状态码、默认错误消息和数据的结果对象
     **/
    public static Result error(Object data){
        Result result = new Result(data);
        result.setCode(ResultCodeEnum.SYSTEM_ERROR.code);
        result.setMsg(ResultCodeEnum.SYSTEM_ERROR.msg);
        return result;
    }

    /**
     * 根据自定义状态码和消息创建错误的Result对象。
     * @param code 自定义的状态码
     * @param msg 自定义的错误消息
     * @return Result 包含自定义状态码和消息的结果对象
     **/
    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 根据枚举类型ResultCodeEnum创建错误的Result对象。
     * @param resultCodeEnum 枚举类型，包含状态码和消息
     * @return Result 包含枚举类型指定的状态码和消息的结果对象
     **/
    public static Result error(ResultCodeEnum resultCodeEnum) {
        Result result = new Result();
        result.setCode(resultCodeEnum.code);
        result.setMsg(resultCodeEnum.msg);
        return result;
    }
}
