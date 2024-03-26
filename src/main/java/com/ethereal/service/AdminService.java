package com.ethereal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ethereal.pojo.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
* @author 53609
* @description 针对表【admin(管理员)】的数据库操作Service
* @createDate 2024-03-26 15:36:38
*/
public interface AdminService extends IService<Admin> {
    void add(Admin admin);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    Admin selectById(Integer id);

    List<Admin> selectAll(Admin admin);

    PageInfo<Admin> selectPage(Admin admin, Integer pageNum, Integer pageSize);
}
