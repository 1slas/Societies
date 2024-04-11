package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Notice;
import com.ethereal.service.NoticeService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告控制器
 * @BelongsProject: Societies
 * @BelongsPackage: com.ethereal.controller
 * @Author: Echo
 * @CreateTime: 2024-03-28  17:24
 * @Version: 1.0
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    /**
     * 新增公告
     * @param notice 公告对象，包含公告的详细信息
     * @return 返回操作结果，成功则返回success
     */
    @PostMapping
    public Result add(@RequestBody Notice notice){
        noticeService.add(notice);
        return  Result.success();
    }

    /**
     * 根据ID删除公告
     * @param id 公告的唯一标识符
     * @return 返回操作结果，成功则返回success
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        noticeService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除公告
     * @param ids 公告ID的集合
     * @return 返回操作结果，成功则返回success
     */
    @DeleteMapping("/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        noticeService.deleteBatch(ids);
        return  Result.success();
    }

    /**
     * 根据ID修改公告
     * @param notice 包含修改后公告信息的Notice对象
     * @return 返回操作结果，成功则返回success
     */
    @PutMapping
    public Result updateById(@RequestBody Notice notice){
        noticeService.updateById(notice);
        return Result.success();
    }

    /**
     * 根据ID查询公告
     * @param id 公告的唯一标识符
     * @return 返回查询结果，成功则返回对应的Notice对象
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Notice notice = noticeService.selectById(id);
        return Result.success(notice);
    }

    /**
     * 查询所有公告信息
     * @param notice 包含查询条件的Notice对象
     * @return 返回查询结果，成功则返回公告信息列表
     */
    @GetMapping("/selectAll")
    public Result selectAll(@RequestBody Notice notice){
        List<Notice> list = noticeService.selectAll(notice);
        return Result.success(list);
    }

    /**
     * 分页查询公告
     * @param notice 包含查询条件的Notice对象
     * @param pageNum 页码
     * @param pageSize 每页显示的数量
     * @return 返回分页查询结果，成功则返回PageInfo对象
     */
    @GetMapping("/selectPage")
    public Result selectPage(Notice notice,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10")Integer pageSize){
        PageInfo<Notice> pageInfo = noticeService.selectPage(notice,pageNum,pageSize);
        return Result.success(pageInfo);
    }
}
