package com.ethereal.controller;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import com.ethereal.common.Result;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.pojo.Account;
import com.ethereal.service.AdminService;
import com.ethereal.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 登录注册控制器
 * @BelongsProject: Societies
 * @BelongsPackage: com.ethereal.controller
 * @Author: Echo
 * @CreateTime: 2024-03-29  10:11
 * @Description: 处理登录、注册相关请求
 * @Version: 1.0
 */
@RestController
public class WebController {
    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;

    /**
     * 返回欢迎信息
     * @return Result 包含欢迎信息的结果对象
     */
    @GetMapping("/")
    public Result hello(){
        return Result.success("访问成功");
    }

    /**
     * 用户登录
     * @param account 用户登录信息
     * @return Result 包含登录结果的状态码和信息
     */
    @PostMapping("/login")
    public Result login (Account account){
        // 检查登录参数是否完整
        if (account.getUsername() == null || account.getUsername().isEmpty() &&
                (account.getPassword() == null || account.getPassword().isEmpty()) &&
                (account.getRole() == null || account.getRole().isEmpty())){
            return  Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        // 处理管理员登录
        if(RoleEnum.ADMIN.name().equals(account.getRole())){
            account = adminService.login(account);
        }
        // 处理普通用户登录
        if(RoleEnum.USER.name().equals(account.getRole())){
            account = userService.login(account);
        }
        return Result.success(account);
    }

    /**
     * 注册用户
     * @param account 用户注册信息
     * @return Result 注册结果的状态码和信息
     */
    @PostMapping("/register")
    public Result register(@RequestBody Account account){
        // 检查注册参数是否完整
        if (CharSequenceUtil.isBlank(account.getUsername()) ||
                CharSequenceUtil.isBlank(account.getPassword()) ||
                ObjectUtil.isEmpty(account.getRole())){
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        // 注册管理员
        if (RoleEnum.ADMIN.name().equals(account.getRole())){
            adminService.reister(account);
        }
        // 注册普通用户
        if (RoleEnum.USER.name().equals(account.getRole())){
            userService.reister(account);
        }
        return Result.success();
    }

    /**
     * 修改密码
     * @param account 包含用户名、旧密码、新密码的账户信息
     * @return Result 修改密码的结果状态码和信息
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account){
        // 检查修改密码参数是否完整
        if (CharSequenceUtil.isBlank(account.getUsername()) ||
                CharSequenceUtil.isBlank(account.getPassword()) ||
                ObjectUtil.isEmpty(account.getNewPassword())){
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        // 处理管理员密码修改
        if (RoleEnum.ADMIN.name().equals(account.getRole())){
            adminService.updatePassword(account);
        }
        // 处理普通用户密码修改
        if (RoleEnum.USER.name().equals(account.getRole())){
            userService.updatePassword(account);
        }
        return Result.success();
    }
}
