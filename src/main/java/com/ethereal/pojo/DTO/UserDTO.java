package com.ethereal.pojo.DTO;

import lombok.Data;

/**
 * @BelongsProject: Societies
 * @BelongsPackage: com.ethereal.pojo.DTO
 * @Author: Echo
 * @CreateTime: 2024-03-28  15:09
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String avatar;
    private String role;
    private String level;
    private Integer departmentId;
    private String departmentName;
}
