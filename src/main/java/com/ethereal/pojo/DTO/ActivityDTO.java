package com.ethereal.pojo.DTO;

import lombok.Data;

/**
 * @author 53609
 */

@Data
public class ActivityDTO {
    private Integer id;
    private String img;
    private String name;
    private String description;
    private Integer departmentId;
    private String time;
    private String departmentName;
}
