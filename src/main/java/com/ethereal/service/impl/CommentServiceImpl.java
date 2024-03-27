package com.ethereal.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.mapper.CommentMapper;
import com.ethereal.mapper.DepartmentMapper;
import com.ethereal.pojo.Account;
import com.ethereal.pojo.Comment;
import com.ethereal.pojo.DTO.CommentDTO;
import com.ethereal.pojo.Department;
import com.ethereal.service.CommentService;
import com.ethereal.untils.Token;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

/**
* @author 53609
* @description 针对表【comment(评论信息表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private DepartmentMapper departmentMapper；

    /**
     * 新增
     * @param comment
     */
    @Override
    public void add(Comment comment) {
        comment.setTime(DateUtil.now());
        commentMapper.insert(comment);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        commentMapper.deleteById(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids){
            commentMapper.deleteById(id);
        }
    }
    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public Comment selectById(Integer id) {
        return commentMapper.selectById(id);
    }
    /**
     * 查询评论并将其组织成树形结构
     *
     * @param commentDTO 包含查询条件的评论DTO对象
     * @return 组织成树形结构的评论列表
     */
    @Override
    public List<CommentDTO> selectAll(CommentDTO commentDTO) {
        // 设置顶级评论的父ID为1，以便获取顶级评论
        commentDTO.setParentId(1);
        // 查询满足条件的顶级评论列表
        List<CommentDTO> allParent = commentMapper.selectAll(commentDTO);
        // 遍历顶级评论列表，为每个顶级评论查询其子评论
        for (CommentDTO dbCommentDTO : allParent) {
            // 设置评论DTO的父ID为当前顶级评论的ID，以便查询其子评论
            commentDTO.setParentId(dbCommentDTO.getId());
            // 查询当前顶级评论的子评论列表
            List<CommentDTO> children = commentMapper.selectAll(commentDTO);
            // 将查询到的子评论列表设置到当前顶级评论的children属性中，形成父子关系
            dbCommentDTO.setChildren(children);
        }
        // 返回组织成树形结构的评论列表
        return allParent;
    }

    /**
     * 分页查询
     * @param commentDTO
     * @param pageNum
     * @param pageSize
     * @return
     */

    @Override
    public PageInfo<CommentDTO> selectPage(CommentDTO commentDTO, Integer pageNum, Integer pageSize) {
        Account currentUser = Token.getCurrentUser();
        if(RoleEnum.USER.name().equals(currentUser.getRole())){
            Department department = departmentMapper.selectByUserId(currentUser.getId());
            if(ObjectUtil.isNotEmpty(department)){
                commentDTO.setDepartmentId(department.getId());
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        List<CommentDTO> list = commentMapper.selectAll(commentDTO);
        return PageInfo.of(list);
    }

}




