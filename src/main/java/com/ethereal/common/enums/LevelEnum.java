package com.ethereal.common.enums;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 二级身份枚举
 * @date 2024/3/24 20:21:46
 **/

public enum LevelEnum {
    HEADER("社长"),
    STUDENT("学生"),
    ;
    public String level;

    LevelEnum(String level) {
        this.level = level;
    }
}
