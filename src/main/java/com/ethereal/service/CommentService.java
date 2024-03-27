package com.ethereal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ethereal.pojo.Comment;
import com.ethereal.pojo.DTO.CommentDTO;
import com.github.pagehelper.PageInfo;


import java.util.List;

/**
* @author 53609
* @description 针对表【comment(评论信息表)】的数据库操作Service
* @createDate 2024-03-26 15:36:38
*/
public interface CommentService extends IService<Comment> {

    void add(Comment comment);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    Comment selectById(Integer id);

    List<CommentDTO> selectAll(CommentDTO commentDTO);

    PageInfo<CommentDTO> selectPage(CommentDTO commentDTO, Integer pageNum, Integer pageSize);
}
