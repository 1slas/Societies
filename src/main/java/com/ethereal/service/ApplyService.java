package com.ethereal.service;

import com.ethereal.pojo.Apply;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Echo
 * @version 1.0
 * @project Societies
 * @description
 * @date 2024/3/23 15:12:32
 **/

public interface ApplyService {
    void add(Apply apply);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);
    void updateById(Apply apply);
    Apply selectById(Integer id);
    List<Apply> selectAll(Apply apply);
    PageInfo<Apply> selectPage(Apply apply, Integer pageNum, Integer pageSize);
    void extracted(Apply apply);
    List<Apply> selectMyApply(Apply apply);
}
