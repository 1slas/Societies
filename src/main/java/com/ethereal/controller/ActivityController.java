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
 * 社团活动信息控制层，负责处理HTTP请求
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Resource
    private ActivityService activityService; // 注入活动服务接口

    /**
     * 添加一个新的活动记录
     * @param activity 包含活动信息的对象
     * @return 返回操作结果，成功则返回成功信息
     */
    @PostMapping("/add")
    public Result add(@RequestBody Activity activity) {
        activityService.add(activity);
        return Result.success();
    }

    /**
     * 根据ID删除活动记录
     * @param id 活动的唯一标识符
     * @return 返回操作结果，成功则返回成功信息
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        activityService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除活动记录
     * @param ids 活动ID的列表
     * @return 返回操作结果，成功则返回成功信息
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        activityService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据ID修改活动记录
     * @param activity 包含更新后的活动信息的对象
     * @return 返回操作结果，成功则返回更新后的活动信息
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Activity activity) {
        activityService.updateById(activity);
        return Result.success(activity);
    }

    /**
     * 根据ID查询活动记录
     * @param id 活动的唯一标识符
     * @return 返回操作结果，成功则返回对应的活动信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        ActivityDTO activityDTO = activityService.selectById(id);
        return Result.success(activityDTO);
    }

    /**
     * 查询所有活动记录
     * @param activityDTO 包含查询条件的对象
     * @return 返回操作结果，成功则返回所有活动信息的列表
     */
    @GetMapping("/selectAll")
    public Result selectAll(ActivityDTO activityDTO) {
        List<ActivityDTO> list = activityService.selectAll(activityDTO);
        return Result.success(list);
    }

    /**
     * 分页查询活动记录
     * @param activityDTO 包含查询条件和分页信息的对象
     * @param pageNum 请求的页码
     * @param pageSize 每页显示的数量
     * @return 返回操作结果，成功则返回分页后的活动信息
     */
    @GetMapping("/selectPage")
    public Result selectPage(ActivityDTO activityDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10") Integer pageSize) {
        PageInfo<ActivityDTO> page = activityService.selectPage(activityDTO,pageNum,pageSize);
        return Result.success(page);
    }
}
