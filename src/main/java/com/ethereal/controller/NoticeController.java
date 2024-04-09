package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Notice;
import com.ethereal.service.NoticeService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: Societies
 * @BelongsPackage: com.ethereal.controller
 * @Author: Echo
 * @CreateTime: 2024-03-28  17:24
 * @Description: 公告控制器
 * @Version: 1.0
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;
    /**
     * @param notice:
      * @return Result
     * @author 53609
     * @description 新增公告
     * @date 2024/3/28 17:32
     */
    @PostMapping
    public Result add(@RequestBody Notice notice){
        noticeService.add(notice);
        return  Result.success();
    }
    /**
     * @param id:
      * @return Result
     * @author 53609
     * @description 删除公告
     * @date 2024/3/28 17:37
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        noticeService.deleteById(id);
        return Result.success();
    }
    /**
     * @param ids:
      * @return Result
     * @author 53609
     * @description 批量删除请求
     * @date 2024/3/28 17:41
     */
    @DeleteMapping("/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        noticeService.deleteBatch(ids);
        return  Result.success();
    }
    /**
     * @param notice:
      * @return Result
     * @author 53609
     * @description 修改公告
     * @date 2024/3/28 17:46
     */
    @PutMapping
    public Result updateById(@RequestBody Notice notice){
        noticeService.updateById(notice);
        return Result.success();
    }
    /**
     * @param id:
      * @return Result
     * @author 53609
     * @description 根据id查询公告
     * @date 2024/3/28 17:52
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Notice notice = noticeService.selectById(id);
        return Result.success(notice);
    }
    /**
     * @param notice:
      * @return Result
     * @author 53609
     * @description 获取公告信息列表
     * @date 2024/3/28 17:57
     */
    @GetMapping("/selectAll")
    public Result selectAll(@RequestBody Notice notice){
        List<Notice> list = noticeService.selectAll(notice);
        return Result.success(list);
    }
    @GetMapping("/selectPage")
    public Result selectPage(Notice notice,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10")Integer pageSize){
        PageInfo<Notice> pageInfo = noticeService.selectPage(notice,pageNum,pageSize);
        return Result.success(pageInfo);
    }
}
