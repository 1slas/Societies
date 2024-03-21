package com.ethereal.service.Impl;

import com.ethereal.pojo.Account;
import com.ethereal.pojo.Admin;
import com.ethereal.service.AdminService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description
 * @date 2024/3/23 16:28:45
 **/

public class AdminServiceImpl implements AdminService {
    @Override
    public void add(Admin admin) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Admin admin) {

    }

    @Override
    public Admin selectById(Admin admin) {
        return null;
    }

    @Override
    public List<Admin> selectAll(Admin admin) {
        return null;
    }

    @Override
    public PageInfo<Admin> selectPage(Admin admin, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Account login(Account account) {
        return null;
    }

    @Override
    public void register(Account account) {

    }

    @Override
    public void updatePassword(Account account) {

    }
}
