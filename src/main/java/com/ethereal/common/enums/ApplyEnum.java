package com.ethereal.common.enums;

/**
 * 审核状态枚举类，用于定义各种审核状态。
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 审核枚举，定义了审核过程中的各种状态。
 * @date 2024/3/24 19:04:16
 **/
public enum ApplyEnum {
    // 审核流程头部状态，表示社长正在审核中
    PROCESS_HEADER_APPLYING("社长审核中"),
    // 审核流程头部状态，表示社长已审核完成
    PROCESS_HEADER_APPLIED("审核完成"),

    // 审核状态，表示申请正在等待审核
    STATUS_APPLYING("待审核"),
    // 审核状态，表示申请已通过审核
    STATUS_APPLY_OK("审核通过"),
    // 审核状态，表示申请未通过审核
    STATUS_APPLY_NO("审核不通过")
    ;

    // 审核状态的描述文本
    public String status;

    // 构造函数，用于初始化每个枚举值的状态描述
    ApplyEnum(String status) {
        this.status = status;
    }
}
