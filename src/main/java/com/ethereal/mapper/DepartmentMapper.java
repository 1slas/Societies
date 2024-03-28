package com.ethereal.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethereal.pojo.DTO.DepartmentDTO;
import com.ethereal.pojo.Department;

import java.util.List;

/**
* @author 53609
* @description 针对表【department(社团信息表)】的数据库操作Mapper
* @createDate 2024-03-26 15:36:38
* @Entity generator.domain.Department
*/
public interface DepartmentMapper extends BaseMapper<Department> {
    Department selectByUserId(Integer userId);

    List<DepartmentDTO> selectAll(DepartmentDTO departmentDTO);
}




