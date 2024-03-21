package com.ethereal.service;

import com.ethereal.pojo.Activity;
import com.ethereal.pojo.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description
 * @date 2024/3/23 15:12:02
 **/

public interface ActivityService {
    void add(Activity activity);
    void deleteById(Integer id);
    void deleteBatch(List ids);
    Activity updateById(Integer id);
    List<Activity> selectAll(Activity activity);
    PageInfo<Activity> selectPage(Activity activity, Integer pageNum, Integer pageSize);
}
