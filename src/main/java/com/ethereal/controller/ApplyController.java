package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Apply;
import com.ethereal.pojo.DTO.ApplyDTO;
import com.ethereal.service.ApplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 53609
 */
@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    /**
     * 新增
     */
    @PostMapping("/apply")
    public Result add(@RequestBody Apply apply){
        applyService.add(apply);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/apply/{id}")
    public Result deleteById(@PathVariable Integer id){
         applyService.deleteById(id);
         return Result.success();
    }
    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        applyService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * 修改
     */
    @PutMapping("/apply/{id}")
    public Result updateById(@RequestBody Apply apply){
        applyService.updateById(apply);
        return Result.success();
    }
    /**
     * 查询
     */
    @GetMapping("/apply/{id}")
    public Result selectById(@PathVariable Integer id){
        Apply apply = applyService.selectById(id);
        return Result.success(apply);
    }
    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(ApplyDTO applyDTO){
        List<ApplyDTO> list = applyService.selectAll(applyDTO);
        return Result.success(list);
    }
    /**
     * 查询我的审批
     */
    @GetMapping("/selectMyApply")
    public Result selectMyApply(ApplyDTO applyDTO){
        List<ApplyDTO> list = applyService.selectMyApply(applyDTO);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(ApplyDTO applyDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10") Integer pageSize){
        PageInfo<ApplyDTO> pageInfo = applyService.selectPage(applyDTO,pageNum,pageSize);
        return Result.success(pageInfo);
    }


}
