package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.Admin;
import com.ethereal.service.AdminService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员前端操作接口
 * 提供了管理员的增删改查等接口功能
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService; // 注入AdminService服务

    /**
     * 新增管理员
     * @param admin 包含管理员信息的对象
     * @return 返回操作结果，成功则返回success
     */
    @PostMapping("/add")
    public Result add(@RequestBody Admin admin){
        adminService.add(admin);
        return Result.success();
    }

    /**
     * 根据ID删除管理员
     * @param id 管理员ID
     * @return 返回操作结果，成功则返回success
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id){
        adminService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除管理员
     * @param ids 管理员ID列表
     * @return 返回操作结果，成功则返回success
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        adminService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 根据ID修改管理员信息
     * @param admin 包含修改后管理员信息的对象
     * @return 返回操作结果，成功则返回success
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Admin admin){
        adminService.updateById(admin);
        return Result.success();
    }

    /**
     * 根据ID查询管理员信息
     * @param id 管理员ID
     * @return 返回查询结果，包含指定的管理员信息
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        Admin admin = adminService.selectById(id);
        return Result.success(admin);
    }

    /**
     * 查询所有管理员信息
     * @param admin 管理员对象，可用来过滤查询结果（暂未使用）
     * @return 返回所有管理员信息的列表
     */
    @GetMapping("/selectAll")
    public Result selectAll(Admin admin){
        List<Admin> list = adminService.selectAll(admin);
        return Result.success(list);
    }

    /**
     * 分页查询管理员信息
     * @param admin 管理员对象，可用来过滤查询结果（暂未使用）
     * @param pageNum 查询页码
     * @param pageSize 每页显示数量
     * @return 返回分页查询结果
     */
    @GetMapping("/selectPage")
    public Result selectPage(Admin admin,
                                @RequestParam(value = "1") Integer pageNum,
                                @RequestParam(value = "10") Integer pageSize){
        PageInfo<Admin> page = adminService.selectPage(admin,pageNum,pageSize);
        return Result.success(page);
    }

}
