package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Activity;
import com.ethereal.pojo.DTO.ActivityDTO;
import com.ethereal.service.ActivityService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 53609
 * 社团欢动信息接口
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Resource
    private ActivityService activityService;

    /**
     * 新增
     */
    @PostMapping
    public Result add(@RequestBody Activity activity) {
        activityService.add(activity);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        activityService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        activityService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping
    public Result updateById(@RequestBody Activity activity) {
        activityService.updateById(activity);
        return Result.success(activity);
    }

    /**
     * 查询
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        ActivityDTO activityDTO = activityService.selectById(id);
        return Result.success(activityDTO);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(ActivityDTO activityDTO) {
        List<ActivityDTO> list = activityService.selectAll(activityDTO);
        return Result.success(activityDTO);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(ActivityDTO activityDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10") Integer pageSize) {
        PageInfo<ActivityDTO> page = activityService.selectPage(activityDTO,pageNum,pageSize);
        return Result.success(page);
    }
}
