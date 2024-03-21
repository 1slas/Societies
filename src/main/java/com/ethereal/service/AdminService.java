package com.ethereal.service;

import com.ethereal.pojo.Account;
import com.ethereal.pojo.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description
 * @date 2024/3/23 15:12:16
 **/

public interface AdminService {
    void add(Admin admin);
    void delete(Integer id);
    void update(Admin admin);
    Admin selectById(Admin admin);
    List<Admin> selectAll(Admin admin);
    PageInfo<Admin> selectPage(Admin admin, Integer pageNum, Integer pageSize);
    Account login(Account account);
    void register(Account account);
    void updatePassword(Account account);

}
