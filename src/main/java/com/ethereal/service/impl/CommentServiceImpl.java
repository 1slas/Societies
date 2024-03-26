package com.ethereal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.mapper.CommentMapper;
import com.ethereal.service.CommentService;
import generator.domain.Comment;
import org.springframework.stereotype.Service;

/**
* @author 53609
* @description 针对表【comment(评论信息表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

}




