package com.ethereal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ethereal.pojo.DTO.DepartmentDTO;
import com.ethereal.pojo.Department;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
* @author 53609
* @description 针对表【department(社团信息表)】的数据库操作Service
* @createDate 2024-03-26 15:36:38
*/
public interface DepartmentService extends IService<Department> {

    void add(Department department);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    Department selectById(Integer id);

    List<DepartmentDTO> selectAll(DepartmentDTO departmentDTO);

    PageInfo<DepartmentDTO> selectPage(DepartmentDTO departmentDTO, Integer pageNum, Integer pageSize);
}
