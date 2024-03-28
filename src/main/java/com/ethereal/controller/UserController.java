package com.ethereal.controller;

import com.ethereal.common.Result;
import com.ethereal.pojo.DTO.UserDTO;
import com.ethereal.pojo.User;
import com.ethereal.service.UserService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 53609
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * @param user:
      * @return Result
     * @author 53609
     * @description TODO
     * @date 2024/3/28 14:51
     * 新增用户
     */
    @PostMapping
    public Result add(@RequestBody User user){
        userService.add(user);
        return Result.success();
    }

    /**
     * @param id:
      * @return Result
     * @author 53609
     * @description 删除
     * @date 2024/3/28 14:52
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        userService.deleteById(id);
        return Result.success();
    }
    /**
     * @param ids:
      * @return Result
     * @author 53609
     * @description 批量删除
     * @date 2024/3/28 15:02
     */
    @DeleteMapping("/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids){
        userService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * @param user:
      * @return void
     * @author 53609
     * @description 修改
     * @date 2024/3/28 15:06
     */
    @PutMapping
    public Result updateById(@RequestBody User user){
        userService.updateById(user);
        return Result.success();
    }
    /**
     * @param id:
      * @return Result
     * @author 53609
     * @description 查询用户
     * @date 2024/3/28 15:16
     */
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        User user = userService.selectById(id);
        return Result.success(user);
    }
    /**
     * @param userDTO:
      * @return Result
     * @author 53609
     * @description 获取所有人员信息
     * @date 2024/3/28 15:18
     */
    @GetMapping("/selectAll")
    public Result selectAll(UserDTO userDTO){
        List<UserDTO> list = userService.selectAll(userDTO);
        return Result.success(list);
    }

    @GetMapping("/getAllHeaders")
    public Result getAllHeaders(UserDTO userDTO){
        List<UserDTO> list = userService.getAllHeaders(userDTO);
        return Result.success(list);
    }
    /**
     * @param userDTO:
    	 * @param pageNum:
    	 * @param pageSize:
      * @return Result
     * @author 53609
     * @description 分页查询
     * @date 2024/3/28 17:16
     */
    @GetMapping("/selectPage")
    public Result selectPage(UserDTO userDTO,
                             @RequestParam(value = "1") Integer pageNum,
                             @RequestParam(value = "10")Integer pageSize){
        PageInfo<UserDTO> page = userService.selectPage(userDTO,pageNum,pageSize);
        return Result.success(page);
    }
}
