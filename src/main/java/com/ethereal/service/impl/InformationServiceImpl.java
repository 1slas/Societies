package com.ethereal.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.common.enums.RoleEnum;
import com.ethereal.mapper.DepartmentMapper;
import com.ethereal.mapper.InformationMapper;
import com.ethereal.pojo.Account;
import com.ethereal.pojo.DTO.InformationDTO;
import com.ethereal.pojo.Department;
import com.ethereal.pojo.Information;
import com.ethereal.service.InformationService;
import com.ethereal.untils.Token;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author 53609
* @description 针对表【information(社团资讯表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information>
    implements InformationService {

    @Resource
    private InformationMapper informationMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * @param information:
      * @return void
     * @author 53609
     * @description 新增社团资讯
     * @date 2024/3/29 8:49
     */
    @Override
    public void add(Information information) {
        information.setTime(DateUtil.format(new Date(), "yyyy-MM-dd"));
        //获取社团id
        Account currentUser = Token.getCurrentUser();
        Department department = departmentMapper.selectByUserId(currentUser.getId());
        information.setDepartment_id(department.getId());
        informationMapper.insert(information);
    }

    /**
     * @param id:
      * @return void
     * @author 53609
     * @description 删除社团资讯
     * @date 2024/3/29 8:52
     */
    @Override
    public void deleteById(Integer id) {
        informationMapper.deleteById(id);
    }
    /**
     * @param ids:
      * @return void
     * @author 53609
     * @description 批量删除社团资讯
     * @date 2024/3/29 8:55
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids){
            informationMapper.deleteById(id);
        }
    }
    /**
     * @param id:
      * @return InformationDTO
     * @author 53609
     * @description 根据id进行查询
     * @date 2024/3/29 9:05
     */
    @Override
    public InformationDTO selectById(Integer id) {
        InformationDTO informationDTO = informationMapper.selectById(id);
        Department department = departmentMapper.selectById(informationDTO.getDepartmentId());
        if (ObjectUtil.isNotEmpty(department)){
            informationDTO.setDepartmentName(department.getName());
        }
        return informationDTO;
    }
    /**
     * @param informationDTO:
      * @return List<InformationDTO>
     * @author 53609
     * @description 获取列表信息
     * @date 2024/3/29 9:08
     */
    @Override
    public List<InformationDTO> selectAll(InformationDTO informationDTO) {
        List<InformationDTO> activities = informationMapper.selectAll(informationDTO);
        for (InformationDTO dbInformation : activities){
            dbInformation.setDescription(dbInformation.getDescription().replaceAll("<p>", "").replaceAll("</p>", ""));
        }
        return activities;
    }
    /**
     * @param informationDTO:
    	 * @param pageNum:
    	 * @param pageSize:
      * @return PageInfo<InformationDTO>
     * @author 53609
     * @description 分页查询
     * @date 2024/3/29 10:11
     */
    @Override
    public PageInfo<InformationDTO> selectPage(InformationDTO informationDTO, Integer pageNum, Integer pageSize) {
        Account currentUser = Token.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getRole())){
            Department department = departmentMapper.selectByUserId(currentUser.getId());
            if(ObjectUtil.isNotEmpty(department)){
                informationDTO.setDepartmentId(department.getId());
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        List<InformationDTO> list = informationMapper.selectAll(informationDTO);
        return PageInfo.of(list);
    }

}




