package com.ethereal.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethereal.pojo.DTO.UserDTO;
import com.ethereal.pojo.User;

import java.util.List;

/**
* @author 53609
* @description 针对表【user(学生信息表)】的数据库操作Mapper
* @createDate 2024-03-26 15:36:38
* @Entity generator.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    List<UserDTO> selectAll(UserDTO userDTO);

    User selectByUsername(String username);
}




