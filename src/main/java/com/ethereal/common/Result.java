package com.ethereal.common;

import com.ethereal.common.enums.ResultCodeEnum;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 统一封装类
 * @date 2024/3/23 14:28:45
 **/

public class Result {
    private String code;
    private String msg;
    private Object data;

    public Result(Object data) {
        this.data = data;
    }

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SUCCESS.code);
        result.setMsg(ResultCodeEnum.SYSTEM_ERROR.msg);
        return result;
    }

    public static Result success(Object data){
        Result result = new Result(data);
        result.setCode(ResultCodeEnum.SUCCESS.code);
        result.setMsg(ResultCodeEnum.SYSTEM_ERROR.msg);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(ResultCodeEnum.SYSTEM_ERROR.code);
        result.setMsg(ResultCodeEnum.SYSTEM_ERROR.msg);
        return result;
    }

    public static Result error(Object data){
        Result result = new Result(data);
        result.setCode(ResultCodeEnum.SYSTEM_ERROR.code);
        result.setMsg(ResultCodeEnum.SYSTEM_ERROR.msg);
        return result;
    }
}
