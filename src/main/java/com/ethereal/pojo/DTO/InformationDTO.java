package com.ethereal.pojo.DTO;

import lombok.Data;

/**
 * @BelongsProject: Societies
 * @BelongsPackage: com.ethereal.pojo.DTO
 * @Author: Echo
 * @CreateTime: 2024-03-29  08:59
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class InformationDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer departmentId;
    private String time;
    private String departmentName;
}
