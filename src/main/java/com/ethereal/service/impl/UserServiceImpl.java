package com.ethereal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.mapper.UserMapper;
import com.ethereal.service.UserService;
import generator.domain.User;
import org.springframework.stereotype.Service;

/**
* @author 53609
* @description 针对表【user(学生信息表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




