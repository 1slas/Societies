package com.ethereal.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethereal.pojo.Apply;
import com.ethereal.pojo.DTO.ApplyDTO;

import java.util.List;

/**
* @author 53609
* @description 针对表【apply(申请审批表)】的数据库操作Mapper
* @createDate 2024-03-26 15:36:38
* @Entity generator.domain.Apply
*/
public interface ApplyMapper extends BaseMapper<Apply> {

    List<Apply> selectByStatus(Integer id, Integer departmentId);

    List<ApplyDTO> selectAll(ApplyDTO applyDTO);

}




