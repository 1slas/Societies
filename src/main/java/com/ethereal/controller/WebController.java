package com.ethereal.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.ethereal.common.Result;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.pojo.Account;
import com.ethereal.service.AdminService;
import com.ethereal.service.UserService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Results;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: Societies
 * @BelongsPackage: com.ethereal.controller
 * @Author: Echo
 * @CreateTime: 2024-03-29  10:11
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
public class WebController {
    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;

    @GetMapping("/")
    public Result hello(){
        return Result.success("访问成功");
    }
    /**
     * @param account:
      * @return Result
     * @author 53609
     * @description 登录
     * @date 2024/3/29 10:33
     */
    @PostMapping("/login")
    public Result login (@RequestBody Account account){
        if (account.getUsername().equals("") || account.getUsername() == null ){
            if( account.getPassword().equals("") || account.getPassword() == null ){
                if(account.getRole().equals("") || account.getRole() == null){
                    return  Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
                }
            }

        }
        if(RoleEnum.ADMIN.name().equals(account.getRole())){
            account = adminService.login(account);
        }
        if(RoleEnum.USER.name().equals(account.getRole())){
            account = userService.login(account);
        }
        return Result.success(account);
    }
    /**
     * @param account:
      * @return Result
     * @author 53609
     * @description 注册用户
     * @date 2024/3/29 13:45
     */
    @PostMapping("/register")
    public Result register(@RequestBody Account account){
        if (StrUtil.isBlank(account.getUsername())||StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())){
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())){
            adminService.reister(account);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())){
            userService.reister(account);
        }
        return Result.success();
    }
    /**
     * @param account:
      * @return Result
     * @author 53609
     * @description 修改密码
     * @date 2024/3/29 14:02
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account){
        if (StrUtil.isBlank(account.getUsername())|| StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getNewPassword())){
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())){
            adminService.updatePassword(account);
        }
        if (RoleEnum.USER.name().equals(account.getRole())){
            userService.updatePassword(account);
        }
        return Result.success();
    }
}
