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
 * @description 社团活动实体类
 * @date 2024/3/23 14:56:35
 **/

@TableName(value ="activity")
@Data
public class Activity implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宣传图片
     */
    @TableField(value = "img")
    private String img;

    /**
     * 活动标题
     */
    @TableField(value = "name")
    private String name;

    /**
     * 发布时间
     */
    @TableField(value = "time")
    private String time;

    /**
     * 活动内容
     */
    @TableField(value = "description")
    private String description;

    /**
     * 社团ID
     */
    @TableField(value = "department_id")
    private Integer department_id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}