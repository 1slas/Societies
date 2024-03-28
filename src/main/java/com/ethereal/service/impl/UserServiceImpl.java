package com.ethereal.service.impl;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.common.Constants;
import com.ethereal.common.enums.LevelEnum;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.exception.CustomException;
import com.ethereal.mapper.DepartmentMapper;
import com.ethereal.mapper.UserMapper;
import com.ethereal.pojo.DTO.UserDTO;
import com.ethereal.pojo.Department;
import com.ethereal.pojo.User;
import com.ethereal.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author 53609
 * @description 针对表【user(学生信息表)】的数据库操作Service实现
 * @createDate 2024-03-26 15:36:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * @param user:
     * @return void
     * @author 53609
     * @description TODO
     * @date 2024/3/28 14:50
     */
    @Override
    public void add(User user) {
        User dbUser = userMapper.selectByUsername(user.getUsername());
        if (ObjectUtil.isNotNull(dbUser)) {
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isNotEmpty(user.getPassword())) {
            user.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        if (ObjectUtil.isEmpty(user.getName())) {
            user.setName(user.getUsername());
        }
        user.setName(RoleEnum.USER.name());
        userMapper.insert(user);
    }

    /**
     * @param id:
     * @return void
     * @author 53609
     * @description 删除
     * @date 2024/3/28 14:53
     */
    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    /**
     * @param ids:
     * @return void
     * @author 53609
     * @description 批量删除
     * @date 2024/3/28 15:00
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            userMapper.deleteById(id);
        }
    }

    /**
     * @param id:
     * @return User
     * @author 53609
     * @description 查询用户
     * @date 2024/3/28 15:16
     */
    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * @param userDTO:
     * @return List<User>
     * @author 53609
     * @description 获取用户所有信息
     * @date 2024/3/28 16:20
     */
    @Override
    public List<UserDTO> selectAll(UserDTO userDTO) {
        return userMapper.selectAll(userDTO);
    }

    @Override
    public List<UserDTO> getAllHeaders(UserDTO userDTO) {
        userDTO.setLevel(LevelEnum.HEADER.level);
        return userMapper.selectAll(userDTO);
    }

    @Override
    public PageInfo<UserDTO> selectPage(UserDTO userDTO, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserDTO> list = userMapper.selectAll(userDTO);
        for (UserDTO dbUserDTO : list) {
            if (ObjectUtil.isNotEmpty(dbUserDTO.getLevel()) && LevelEnum.HEADER.level.equals(dbUserDTO.getLevel())) {
                Department department = departmentMapper.selectByUserId(dbUserDTO.getId());
                if (ObjectUtil.isNotEmpty(department)) {
                    dbUserDTO.setDepartmentName(department.getName());
                }
            }
        }
        return PageInfo.of(list);
    }
}




