package com.ethereal.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ethereal.pojo.Activity;
import com.ethereal.pojo.DTO.ActivityDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* @author 53609
* @description 针对表【activity(社团活动表)】的数据库操作Service
* @createDate 2024-03-26 15:36:38
*/
public interface ActivityService extends IService<Activity> {


    void add(Activity activity);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    ActivityDTO selectById(Integer id);

    List<ActivityDTO> selectAll(ActivityDTO activityDTO);

    PageInfo<ActivityDTO> selectPage(ActivityDTO activity, Integer pageNum, Integer pageSize);
}
