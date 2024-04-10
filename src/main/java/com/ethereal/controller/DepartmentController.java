package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.DTO.DepartmentDTO;
import com.ethereal.pojo.Department;
import com.ethereal.service.DepartmentService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门控制器，负责处理部门相关的HTTP请求
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService; // 注入部门服务

    /**
     * 新增部门
     * @param department 部门对象，包含部门信息
     * @return 返回操作结果，成功或失败
     */
    @PostMapping("/add")
    public Result add(@RequestBody Department department){
        departmentService.add(department);
        return Result.success();
    }

    /**
     * 根据ID删除部门
     * @param id 部门ID
     * @return 返回操作结果，成功或失败
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id){
        departmentService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除部门
     * @param ids 部门ID列表
     * @return 返回操作结果，成功或失败
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        departmentService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据ID查询部门信息
     * @param id 部门ID
     * @return 返回查询结果，包含部门信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        Department department = departmentService.selectById(id);
        return Result.success(department);
    }

    /**
     * 查询所有部门信息
     * @param departmentDTO 部门DTO，可用于过滤查询条件
     * @return 返回所有部门信息列表
     */
    @GetMapping("/selectAll")
    public Result selectAll(DepartmentDTO departmentDTO){
        List<DepartmentDTO> list = departmentService.selectAll(departmentDTO);
        return Result.success(list);
    }

    /**
     * 分页查询部门信息
     * @param departmentDTO 部门DTO，可用于过滤查询条件
     * @param pageNum 页码
     * @param pageSize 每页显示数量
     * @return 返回分页查询结果
     */
    @GetMapping("/selectPage")
    public Result selectPage(DepartmentDTO departmentDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10") Integer pageSize){
        PageInfo<DepartmentDTO> page = departmentService.selectPage(departmentDTO,pageNum,pageSize);
        return Result.success(page);
    }
}
