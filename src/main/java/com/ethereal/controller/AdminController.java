package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Admin;
import com.ethereal.service.AdminService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 53609
 * 管理员前端操作接口
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 新增
     */
    @PostMapping("/admin")
    public Result add(@RequestBody Admin admin){
        adminService.add(admin);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/admin/{id}")
    public Result deleteById(@PathVariable Integer id){
        adminService.deleteById(id);
        return Result.success();
    }
    /**
     * 批量删除
     */
    @DeleteMapping("/admin/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        adminService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * 修改
     */
    @PutMapping("/admin/{id}")
    public Result updateById(@RequestBody Admin admin){
        adminService.updateById(admin);
        return Result.success();
    }
    /**
     * 根据id查询
     */
    @GetMapping("admin/{id}")
    public Result selectById(@PathVariable Integer id){
        Admin admin = adminService.selectById(id);
        return Result.success(admin);
    }
    /**
     * 查询所有
     */
    @GetMapping("/admin")
    public Result selectAll(Admin admin){
        List<Admin> list = adminService.selectAll(admin);
        return Result.success(list);
    }
    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Admin admin,
                                @RequestParam(value = "1") Integer pageNum,
                                @RequestParam(value = "10") Integer pageSize){
        PageInfo<Admin> page = adminService.selectPage(admin,pageNum,pageSize);
        return Result.success(page);
        }

    }


