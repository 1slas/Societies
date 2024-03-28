package com.ethereal.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.ethereal.pojo.DTO.InformationDTO;
import lombok.Data;
/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 社团信息实体类
 * @date 2024/3/23 15:08:49
 **/

@TableName(value ="information")
@Data
public class Information extends InformationDTO implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 资讯标题
     */
    @TableField(value = "name")
    private String name;

    /**
     * 资讯内容
     */
    @TableField(value = "description")
    private String description;

    /**
     * 发布时间
     */
    @TableField(value = "time")
    private String time;

    /**
     * 社团ID
     */
    @TableField(value = "department_id")
    private Integer department_id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
