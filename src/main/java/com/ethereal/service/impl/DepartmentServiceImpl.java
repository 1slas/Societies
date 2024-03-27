package com.ethereal.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.exception.CustomException;
import com.ethereal.mapper.DepartmentMapper;
import com.ethereal.pojo.Department;
import com.ethereal.service.DepartmentService;
import generator.domain.Department;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 53609
* @description 针对表【department(社团信息表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 新增
     * @param department
     */
    @Override
    public void add(Department department) {
        if (ObjectUtil.isNotEmpty(department.getUser_id())){
            Department dbDepartment = departmentMapper.selectByUserId(department.getUser_id());
            if (ObjectUtil.isNotEmpty(department)){
                throw new CustomException(ResultCodeEnum.HEADER_ALREADY_ERROR);
            }
        }
        department.setTime(DateUtil.format(new Date(),"yyyy-MM-dd"));
        departmentMapper.insert(department);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        departmentMapper.deleteById(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids){
            departmentMapper.deleteById(id);
        }
    }


}




