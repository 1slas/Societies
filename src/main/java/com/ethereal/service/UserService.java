package com.ethereal.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ethereal.pojo.DTO.UserDTO;
import com.ethereal.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* @author 53609
* @description 针对表【user(学生信息表)】的数据库操作Service
* @createDate 2024-03-26 15:36:38
*/
public interface UserService extends IService<User> {

    void add(User user);
    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    User selectById(Integer id);

    List<UserDTO> selectAll(UserDTO userDTO);

    List<UserDTO> getAllHeaders(UserDTO userDTO);

    PageInfo<UserDTO> selectPage(UserDTO userDTO, Integer pageNum, Integer pageSize);
}
