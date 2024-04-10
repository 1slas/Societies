package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Apply;
import com.ethereal.pojo.DTO.ApplyDTO;
import com.ethereal.service.ApplyService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 申请控制器类，负责处理申请相关的HTTP请求
 */
@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    /**
     * 新增申请信息
     *
     * @param apply 包含申请信息的对象
     * @return 返回操作结果，成功则返回success
     */
    @PostMapping("/add")
    public Result add(@RequestBody Apply apply){
        applyService.add(apply);
        return Result.success();
    }

    /**
     * 根据ID删除申请信息
     *
     * @param id 申请的ID
     * @return 返回操作结果，成功则返回success
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id){
        applyService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除申请信息
     *
     * @param ids 申请ID的列表
     * @return 返回操作结果，成功则返回success
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        applyService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据ID修改申请信息
     *
     * @param apply 包含更新后的申请信息的对象
     * @return 返回操作结果，成功则返回success
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Apply apply){
        applyService.updateById(apply);
        return Result.success();
    }

    /**
     * 根据ID查询申请信息
     *
     * @param id 申请的ID
     * @return 返回查询结果，包含指定ID的申请信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        Apply apply = applyService.selectById(id);
        return Result.success(apply);
    }

    /**
     * 查询所有申请信息
     *
     * @param applyDTO 包含查询条件的对象
     * @return 返回操作结果，包含所有申请信息的列表
     */
    @GetMapping("/selectAll")
    public Result selectAll(ApplyDTO applyDTO){
        List<ApplyDTO> list = applyService.selectAll(applyDTO);
        return Result.success(list);
    }

    /**
     * 查询我的申请
     *
     * @param applyDTO 包含查询条件的对象
     * @return 返回操作结果，包含我发起的申请信息的列表
     */
    @GetMapping("/selectMyApply")
    public Result selectMyApply(ApplyDTO applyDTO){
        List<ApplyDTO> list = applyService.selectMyApply(applyDTO);
        return Result.success(list);
    }

    /**
     * 分页查询申请信息
     *
     * @param applyDTO 包含查询条件和分页信息的对象
     * @param pageNum 页码
     * @param pageSize 每页显示的数量
     * @return 返回操作结果，包含分页查询结果的信息
     */
    @GetMapping("/selectPage")
    public Result selectPage(ApplyDTO applyDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10") Integer pageSize){
        PageInfo<ApplyDTO> pageInfo = applyService.selectPage(applyDTO,pageNum,pageSize);
        return Result.success(pageInfo);
    }


}
