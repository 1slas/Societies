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
 * @description 公告信息实体类
 * @date 2024/3/23 15:09:48
 **/

@TableName(value ="notice")
@Data
public class Notice implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 创建时间
     */
    @TableField(value = "time")
    private String time;

    /**
     * 创建人
     */
    @TableField(value = "user")
    private String user;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}