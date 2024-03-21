package com.ethereal.pojo;

import lombok.Data;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description 用户角色父类
 * @date 2024/3/23 15:36:37
 **/
@Data
public class Account {
    private Integer id;
    /** 用户名 */
    private String username;
    /** 名称 */
    private String name;
    /** 密码 */
    private String password;
    /** 角色标识 */
    private String role;
    /** 新密码 */
    private String newPassword;
    /** 头像 */
    private String avatar;

    private String token;
}
