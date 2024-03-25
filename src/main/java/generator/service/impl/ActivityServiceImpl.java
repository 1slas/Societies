package generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Activity;
import generator.service.ActivityService;
import generator.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;

/**
* @author 53609
* @description 针对表【activity(社团活动表)】的数据库操作Service实现
* @createDate 2024-03-25 17:34:54
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService{

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public Long selectAllAc() {
        QueryWrapper<Activity> activityQueryWrapper = new QueryWrapper<>();
        activityQueryWrapper.select("data");
        Long l = activityMapper.selectCount(activityQueryWrapper);

        return l;
    }
}
