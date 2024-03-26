package com.ethereal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.mapper.DepartmentMapper;
import com.ethereal.service.DepartmentService;
import generator.domain.Department;
import org.springframework.stereotype.Service;

/**
* @author 53609
* @description 针对表【department(社团信息表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService {

}




