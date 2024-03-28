package com.ethereal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.common.Constants;
import com.ethereal.common.enums.ResultCodeEnum;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.exception.CustomException;
import com.ethereal.mapper.AdminMapper;
import com.ethereal.pojo.Account;
import com.ethereal.pojo.Admin;
import com.ethereal.service.AdminService;
import com.ethereal.untils.Token;
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
    /**
     * @param account:
      * @return Account
     * @author 53609
     * @description 登录
     * @date 2024/3/29 10:30
     */
    @Override
    public Account login(Account account) {
        Account dbAdmin = adminMapper.selectByUsername(account.getUsername());
        if (ObjectUtil.isNull(dbAdmin)){
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        if(!account.getPassword().equals(dbAdmin.getPassword())){
            throw new CustomException(ResultCodeEnum.USER_ACCOUNT_ERROR);
        }
        //生产token
        String tokenData = dbAdmin.getId() + "-" + RoleEnum.ADMIN.name();
        String token = Token.creatToken(tokenData,dbAdmin.getPassword());
        dbAdmin.setToken(token);
        return dbAdmin;
    }
    /**
     * @param account:
      * @return void
     * @author 53609
     * @description 注册用户
     * @date 2024/3/29 13:52
     */
    @Override
    public void reister(Account account) {
        Admin admin = new Admin();
        BeanUtil.copyProperties(account,admin);
        add(admin);
    }
    /**
     * @param account:
      * @return void
     * @author 53609
     * @description 修改密码
     * @date 2024/3/29 13:55
     */
    @Override
    public void updatePassword(Account account) {
       Admin dbAdmin = adminMapper.selectByUsername(account.getUsername());
       if (ObjectUtil.isNull(dbAdmin)){
           throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
       }
       if (!account.getPassword().equals(dbAdmin.getPassword())){
           throw new CustomException(ResultCodeEnum.PARAM_PASSWORD_ERROR);
       }
       dbAdmin.setPassword(account.getPassword());
       adminMapper.updateById(dbAdmin);
    }

}




