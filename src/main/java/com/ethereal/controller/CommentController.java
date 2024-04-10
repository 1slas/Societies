package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Comment;
import com.ethereal.pojo.DTO.CommentDTO;
import com.ethereal.service.CommentService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论控制器
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    /**
     * 新增评论
     *
     * @param comment 待添加的评论对象
     * @return 返回操作结果，成功则返回success
     */
    @PostMapping("/add")
    public Result add(@RequestBody Comment comment){
        commentService.add(comment);
        return Result.success();
    }

    /**
     * 根据ID删除评论
     *
     * @param id 评论的ID
     * @return 返回操作结果，成功则返回success
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id){
        commentService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除评论
     *
     * @param ids 待删除评论的ID列表
     * @return 返回操作结果，成功则返回success
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        commentService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据ID修改评论
     *
     * @param comment 待更新的评论对象
     * @return 返回操作结果，成功则返回success
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Comment comment){
        commentService.updateById(comment);
        return Result.success();
    }

    /**
     * 根据ID查询评论
     *
     * @param id 评论的ID
     * @return 返回查询结果，成功则返回该条评论
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        Comment comment = commentService.selectById(id);
        return Result.success(comment);
    }

    /**
     * 查询所有评论
     *
     * @param commentDTO 包含查询条件的对象
     * @return 返回操作结果，成功则返回所有评论列表
     */
    @GetMapping("/selectAll")
    public Result selectAll(@RequestBody CommentDTO commentDTO){
        List<CommentDTO> list = commentService.selectAll(commentDTO);
        return Result.success(list);
    }

    /**
     * 分页查询评论
     *
     * @param commentDTO 包含查询条件和分页信息的对象
     * @param pageNum    请求的页码
     * @param pageSize   每页的记录数
     * @return 返回操作结果，成功则返回分页信息
     */
    @GetMapping("/selectPage")
    public Result selectPage(CommentDTO commentDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10") Integer pageSize){
        PageInfo<CommentDTO> pageInfo = commentService.selectPage(commentDTO,pageNum,pageSize);
        return Result.success(pageInfo);
    }
}
