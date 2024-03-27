package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Department;
import com.ethereal.service.DepartmentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 53609
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    /**
     * 新增
     */
    @PostMapping("/department")
    public Result add(@RequestBody Department department){
        departmentService.add(department);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/department/{id}")
    public Result deleteById(@PathVariable Integer id){
        departmentService.deleteById(id);
        return Result.success();
    }
    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        departmentService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * 根据id查询
     */
    @GetMapping("/department/{id}")
    public Result selectById(@PathVariable Integer id){
        Department department = departmentService.selectById(id);
        return Result.s
    }


}
