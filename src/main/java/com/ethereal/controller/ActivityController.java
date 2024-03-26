package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Activity;
import com.ethereal.service.ActivityService;
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
    @PostMapping("/activity")
    public Result add(@RequestBody Activity activity){
        activityService.add(activity);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/activity/{id}")
    public Result delete(@PathVariable Integer id){
        activityService.deleteById(id);
        return Result.success();
    }
    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        activityService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * 修改
     */
    @PutMapping("/activity/{id}")
    public Result updateById(@RequestBody Activity activity){
        activityService.updateById(activity);
        return Result.success(activity);
    }
    /**
     * 查询
     */
    @GetMapping("/activity/{id}")
    public Result selectById(@PathVariable Integer id){
        Activity activity = activityService.selectById(id);
        return Result.success(activity);
    }
}
