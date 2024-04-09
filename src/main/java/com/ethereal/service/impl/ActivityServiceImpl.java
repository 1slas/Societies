package com.ethereal.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.mapper.ActivityMapper;
import com.ethereal.mapper.DepartmentMapper;
import com.ethereal.pojo.Account;
import com.ethereal.pojo.Activity;
import com.ethereal.pojo.DTO.ActivityDTO;
import com.ethereal.pojo.Department;
import com.ethereal.service.ActivityService;
import com.ethereal.untils.Token;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void add(Activity activity) {
        activity.setTime(DateUtil.format(new Date(), "yyyy-MM-dd"));
        //获取社团id
        Account currentUser = Token.getCurrentUser();
        Department department = departmentMapper.selectById(currentUser.getId());
        activity.setDepartmentId(department.getId());
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
    public ActivityDTO selectById(Integer id) {
        ActivityDTO activityDTO = activityMapper.selectById(id);
        Department department = departmentMapper.selectById(activityDTO.getId());
        if (ObjectUtil.isNotNull(department)){
            activityDTO.setDepartmentName(department.getName());
        }
        return activityDTO;
    }

    /**
     * 查询所有数据
     * @param activityDTO
     * @return
     */
    @Override
    public List<ActivityDTO> selectAll(ActivityDTO activityDTO) {
        List<ActivityDTO> activityDTOS = activityMapper.selectAll(activityDTO);
        for (ActivityDTO dbActivityDTO : activityDTOS){
            dbActivityDTO.setDescription(dbActivityDTO.getDescription().replaceAll("<p>","").replaceAll("</p>",""));
        }
        return activityDTOS;
    }

    @Override
    public PageInfo<ActivityDTO> selectPage(ActivityDTO activity, Integer pageNum, Integer pageSize) {
        Account currentUser = Token.getCurrentUser();
        if(RoleEnum.USER.name().equals(currentUser.getRole())){
            Department department = departmentMapper.selectById(currentUser.getId());
            if (ObjectUtil.isNotEmpty(department)){
                activity.setDepartmentId(department.getId());
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ActivityDTO> list = activityMapper.selectAll(activity);
        return PageInfo.of(list);
    }

}




