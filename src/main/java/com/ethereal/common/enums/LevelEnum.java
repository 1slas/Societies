package com.ethereal.common.enums;

/**
 * 二级身份枚举类
 * 用于定义不同的二级身份角色
 */
public enum LevelEnum {
    /**
     * 社长身份
     */
    HEADER("社长"),
    /**
     * 学生身份
     */
    STUDENT("学生"),
    ;

    // 成员变量level表示每个身份的名称
    public String level;

    // 构造函数，用于初始化每个身份的level值
    LevelEnum(String level) {
        this.level = level;
    }
}
