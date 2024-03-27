package com.ethereal.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethereal.pojo.Activity;
import com.ethereal.pojo.DTO.ActivityDTO;

import java.util.List;

/**
* @author 53609
* @description 针对表【activity(社团活动表)】的数据库操作Mapper
* @createDate 2024-03-26 15:36:38
* @Entity generator.domain.Activity
*/
public interface ActivityMapper extends BaseMapper<Activity> {

    List<ActivityDTO> selectAll(ActivityDTO activityDTO);
}




