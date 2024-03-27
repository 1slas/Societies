package com.ethereal.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.common.enums.ApplyEnum;
import com.ethereal.common.enums.LevelEnum;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.exception.CustomException;
import com.ethereal.mapper.ApplyMapper;
import com.ethereal.mapper.DepartmentMapper;
import com.ethereal.mapper.UserMapper;
import com.ethereal.pojo.Account;
import com.ethereal.pojo.Apply;
import com.ethereal.pojo.DTO.ApplyDTO;
import com.ethereal.pojo.Department;
import com.ethereal.pojo.User;
import com.ethereal.service.ApplyService;
import com.ethereal.untils.Token;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 53609
* @description 针对表【apply(申请审批表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply>
    implements ApplyService {
    @Resource
    private ApplyMapper applyMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 新增审批
     * @param apply
     */
    @Override
    public void add(Apply apply) {
        //先查询该学生有没有申请过该社团
        List<Apply> list  = applyMapper.selectByStatus(apply.getId() ,apply.getDepartment_id());
        if (CollectionUtil.isNotEmpty(list)){
            throw new CustomException(ResultCodeEnum.APPLY_ALREADY_ERROR);
        }
        apply.setProcess(ApplyEnum.PROCESS_HEADER_APPLYING.status);
        apply.setStatus(ApplyEnum.STATUS_APPLYING.status);
        applyMapper.insert(apply);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        applyMapper.deleteById(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for(Integer id : ids){
            applyMapper.deleteById(id);
        }
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public Apply selectById(Integer id) {
        return applyMapper.selectById(id);
    }

    /**
     * 查询所有信息
     * @param applyDTO
     * @return
     */
    @Override
    public List<ApplyDTO> selectAll(ApplyDTO applyDTO) {
        return applyMapper.selectAll(applyDTO);
    }

    /**
     * 查询我的审批
     * @param applyDTO
     * @return
     */
    @Override
    public List<ApplyDTO> selectMyApply(ApplyDTO applyDTO) {
        Account currentUser = Token.getCurrentUser();
        applyDTO.setUserId(currentUser.getId());
        return applyMapper.selectAll(applyDTO);
    }

    /**
     * 根据当前登录用户的角色来设置查询条件中的部门ID
     * @param applyDTO
     */
    @Override
    public void extracted(ApplyDTO applyDTO) {
        Account currentUser = Token.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getName())){
            User user = userMapper.selectById(currentUser.getId());
            if (LevelEnum.HEADER.level.equals(user.getLevel())){
                Department department = departmentMapper.selectById(user.getId());
                if (ObjectUtil.isNotEmpty(department)){
                    applyDTO.setDepartmentId(department.getId());
                }
            }
        }
    }

    /**
     * 分页查询
     * @param applyDTO
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<ApplyDTO> selectPage(ApplyDTO applyDTO, Integer pageNum, Integer pageSize) {
        extracted(applyDTO);
        PageHelper.startPage(pageNum,pageSize);
        List<ApplyDTO> list = applyMapper.selectAll(applyDTO);
        return PageInfo.of(list);
    }
}




