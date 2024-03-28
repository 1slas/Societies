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
    @PostMapping
    public Result add(@RequestBody Department department){
        departmentService.add(department);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        departmentService.deleteById(id);
        return Result.success();
    }
    /**
     * 批量删除
     */
    @DeleteMapping("/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        departmentService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Department department = departmentService.selectById(id);
        return Result. success(department);
    }
    /**
     * 查询所有信息
     */
    @GetMapping("/selectAll")
    public Result selectAll(DepartmentDTO departmentDTO){
        List<DepartmentDTO> list = departmentService.selectAll(departmentDTO);
        return Result.success(list);
    }
    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(DepartmentDTO departmentDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10") Integer pageSize){
        PageInfo<DepartmentDTO> page = departmentService.selectPage(departmentDTO,pageNum,pageSize);
        return Result.success(page);
    }


}
