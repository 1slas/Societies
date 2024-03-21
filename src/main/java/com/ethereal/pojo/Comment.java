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
 * @description 评论信息实体类
 * @date 2024/3/23 14:59:23
 **/

@TableName(value ="comment")
@Data
public class Comment implements Serializable {
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
     * 评论时间
     */
    @TableField(value = "time")
    private String time;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 父ID
     */
    @TableField(value = "parent_id")
    private Integer parent_id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}