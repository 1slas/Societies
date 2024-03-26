package com.ethereal.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.mapper.ActivityMapper;
import com.ethereal.mapper.DepartmentMapper;
import com.ethereal.pojo.Account;
import com.ethereal.pojo.Activity;
import com.ethereal.pojo.Department;
import com.ethereal.service.ActivityService;
import com.ethereal.untils.Token;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 53609
* @description 针对表【activity(社团活动表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService {
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 新增
     * @param activity
     */
    @Override
    public void add(Activity activity) {
        activity.setTime(DateUtil.format(new Date(), "yyyy-MM-dd"));
        //获取社团id
        Account currentUser = Token.getCurrentUser();
        Department department = departmentMapper.selectById(currentUser.getId());
        activity.setDepartment_id(department.getId());
        activityMapper.insert(activity);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(Integer id) {
        activityMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids){
            activityMapper.deleteById(id);
        }
    }


    /**
     * 查询
     */
    @Override
    public Activity selectById(Integer id) {
        Activity activity = activityMapper.selectById(id);
        Department department = departmentMapper.selectById(activity.getId());
        if (ObjectUtil.isNotNull(department)){
            activity.
        }
    }
}




