package com.ethereal.service.Impl;

import com.ethereal.mapper.AdminMapper;
import com.ethereal.pojo.Activity;
import com.ethereal.pojo.Admin;
import com.ethereal.service.ActivityService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description
 * @date 2024/3/23 16:16:32
 **/
@Service
public class ActivityServiceImpl implements ActivityService {


    @Override
    public void add(Activity activity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteBatch(List ids) {

    }

    @Override
    public Activity updateById(Integer id) {
        return null;
    }

    @Override
    public List<Activity> selectAll(Activity activity) {
        return null;
    }

    @Override
    public PageInfo<Activity> selectPage(Activity activity, Integer pageNum, Integer pageSize) {
        return null;
    }
}
