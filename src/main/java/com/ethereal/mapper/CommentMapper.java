package com.ethereal.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethereal.pojo.Comment;
import com.ethereal.pojo.DTO.CommentDTO;

import java.util.List;

/**
* @author 53609
* @description 针对表【comment(评论信息表)】的数据库操作Mapper
* @createDate 2024-03-26 15:36:38
* @Entity generator.domain.Comment
*/
public interface CommentMapper extends BaseMapper<Comment> {

    List<CommentDTO> selectAll(CommentDTO commentDTO);
}




