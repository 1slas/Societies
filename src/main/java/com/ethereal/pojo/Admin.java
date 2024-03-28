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
 * @description 管理员实体类
 * @date 2024/3/23 14:57:47
 **/

@TableName(value ="admin")
@Data
public class Admin extends Account implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 角色标识
     */
    @TableField(value = "role")
    private String role;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
