package com.ethereal.service.Impl;

import com.ethereal.pojo.Comment;
import com.ethereal.service.CommentService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description
 * @date 2024/3/23 16:30:08
 **/

public class CommentServiceImpl implements CommentService {
    @Override
    public void add(Comment comment) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteBatch(List<Integer> ids) {

    }

    @Override
    public void updateById(Comment comment) {

    }

    @Override
    public Comment selectById(Integer id) {
        return null;
    }

    @Override
    public List<Comment> selectAll(Comment comment) {
        return null;
    }

    @Override
    public PageInfo<Comment> selectPage(Comment comment, Integer pageNum, Integer pageSize) {
        return null;
    }
}
