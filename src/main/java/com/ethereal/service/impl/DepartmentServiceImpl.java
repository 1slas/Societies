package com.ethereal.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.common.enums.LevelEnum;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.exception.CustomException;
import com.ethereal.mapper.DepartmentMapper;
import com.ethereal.mapper.UserMapper;
import com.ethereal.pojo.Account;
import com.ethereal.pojo.DTO.DepartmentDTO;
import com.ethereal.pojo.Department;
import com.ethereal.pojo.User;
import com.ethereal.service.DepartmentService;
import com.ethereal.untils.Token;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @Resource
    private UserMapper userMapper;

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

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Department selectById(Integer id) {
        return departmentMapper.selectById(id);
    }

    /**
     * 查询所有信息
     * @param departmentDTO
     * @return
     */
    @Override
    public List<DepartmentDTO> selectAll(DepartmentDTO departmentDTO) {
        return departmentMapper.selectAll(departmentDTO);
    }

    /**
     * 分页查询
     * @param departmentDTO
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<DepartmentDTO> selectPage(DepartmentDTO departmentDTO, Integer pageNum, Integer pageSize) {
        Account currentUser = Token.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getRole())){
            User user = userMapper.selectById(currentUser.getId());
            if (LevelEnum.HEADER.level.equals(user.getLevel())){
                departmentDTO.setUserId(user.getId());
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        List<DepartmentDTO> list = departmentMapper.selectAll(departmentDTO);
        return PageInfo.of(list);
    }


}




