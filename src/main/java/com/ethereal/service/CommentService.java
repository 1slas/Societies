package com.ethereal.service;

import com.ethereal.pojo.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description
 * @date 2024/3/23 15:12:51
 **/

public interface CommentService {
    void add(Comment comment);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Comment comment);
    Comment selectById(Integer id);
    List<Comment> selectAll(Comment comment);
    PageInfo<Comment> selectPage(Comment comment, Integer pageNum, Integer pageSize);
}
