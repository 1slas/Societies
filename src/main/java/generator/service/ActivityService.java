package generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import generator.domain.Activity;


/**
* @author 53609
* @description 针对表【activity(社团活动表)】的数据库操作Service
* @createDate 2024-03-25 17:34:54
*/
public interface ActivityService extends IService<Activity> {
    public Long selectAllAc();
}
