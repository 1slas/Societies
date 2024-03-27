package com.ethereal.pojo.DTO;

import com.ethereal.pojo.Comment;
import lombok.Data;

import java.util.List;


/**
 * @author 53609
 */
@Data
public class CommentDTO {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;
    private Integer departmentId;
    private String time;
    private String content;
    private Integer parentId;
    private String userName;
    private String userAvatar;
    private String departmentName;
    private List<CommentDTO> children;

}
