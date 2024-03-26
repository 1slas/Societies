package com.ethereal.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.common.Constants;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.exception.CustomException;
import com.ethereal.mapper.AdminMapper;
import com.ethereal.pojo.Admin;
import com.ethereal.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 53609
* @description 针对表【admin(管理员)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    /**
     * 新增
     * @param admin
     */
    @Override
    public void add(Admin admin) {
        Admin dbadmin = adminMapper.selectByUsername(admin.getUsername());
        if(ObjectUtil.isNotNull(dbadmin)){
            throw new CustomException(ResultCodeEnum.USER_EXIST_ERROR);
        }
        if(ObjectUtil.isEmpty(admin.getPassword())){
            admin.setPassword(Constants.USER_DEFAULT_PASSWORD);
        }
        if (ObjectUtil.isEmpty(admin.getName())){
            admin.setName(admin.getUsername());
        }
        admin.setRole(RoleEnum.ADMIN.name());
        adminMapper.insert(admin);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids){
            adminMapper.deleteById(id);
        }
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public Admin selectById(Integer id) {
        return adminMapper.selectById(id);
    }

    /**
     * 查询全部信息
     * @param admin
     * @return
     */
    @Override
    public List<Admin> selectAll(Admin admin) {
        return adminMapper.selectAll(admin);
    }

    /**
     * 分页查询
     * @param admin
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Admin> selectPage(Admin admin, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> list = adminMapper.selectAll(admin);
        return PageInfo.of(list);
    }
}




