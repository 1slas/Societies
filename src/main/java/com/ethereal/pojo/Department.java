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
 * @description 社团信息实体类
 * @date 2024/3/23 15:00:36
 **/

@TableName(value ="department")
@Data
public class Department implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 社团logo
     */
    @TableField(value = "img")
    private String img;

    /**
     * 社团名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 社团介绍
     */
    @TableField(value = "description")
    private String description;

    /**
     * 社长ID
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 发布时间
     */
    @TableField(value = "time")
    private String time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
