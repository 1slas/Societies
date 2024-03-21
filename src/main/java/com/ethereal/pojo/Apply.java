package com.ethereal.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 审核审批实体类
 * @date 2024/3/23 14:58:23
 **/

@TableName(value ="apply")
@Data
public class Apply implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生ID
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 社团ID
     */
    @TableField(value = "department_id")
    private Integer department_id;

    /**
     * 申请说明
     */
    @TableField(value = "description")
    private String description;

    /**
     * 当前进度
     */
    @TableField(value = "process")
    private String process;

    /**
     * 审核状态
     */
    @TableField(value = "status")
    private String status;

    /**
     * 审核说明
     */
    @TableField(value = "note")
    private String note;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
