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
 * @author 53609
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    /**
     * 新增
     */
    @PostMapping
    public Result add(@RequestBody Comment comment){
        commentService.add(comment);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        commentService.deleteById(id);
        return Result.success();
    }
    /**
     * 批量删除
     */
    @DeleteMapping("/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        commentService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * 修改
     */
    @PutMapping
    public Result updateById(@RequestBody Comment comment){
        commentService.updateById(comment);
        return Result.success();
    }
    /**
     * 查询
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Comment comment = commentService.selectById(id);
        return Result.success(comment);
    }
    /**
     * 查询所有
     */
    @GetMapping("selectAll")
    public Result selectAll(@RequestBody CommentDTO commentDTO){
        List<CommentDTO> list = commentService.selectAll(commentDTO);
        return Result.success(list);
    }
    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(CommentDTO commentDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10") Integer pageSize){
        PageInfo<CommentDTO> pageInfo = commentService.selectPage(commentDTO,pageNum,pageSize);
        return Result.success(pageInfo);
    }
}
