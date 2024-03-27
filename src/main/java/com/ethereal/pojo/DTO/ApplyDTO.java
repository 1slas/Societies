package com.ethereal.pojo.DTO;

import lombok.Data;

/**
 * @author 53609
 */
@Data
public class ApplyDTO {
    private Integer id;
    private Integer userId;
    private Integer departmentId;
    private String description;
    private String process;
    private String status;
    private String note;
    private String userName;
    private String departmentName;
}
