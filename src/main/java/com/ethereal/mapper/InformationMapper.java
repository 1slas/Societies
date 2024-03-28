package com.ethereal.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethereal.pojo.DTO.InformationDTO;
import com.ethereal.pojo.Information;

import java.util.List;

/**
* @author 53609
* @description 针对表【information(社团资讯表)】的数据库操作Mapper
* @createDate 2024-03-26 15:36:38
* @Entity generator.domain.Information
*/
public interface InformationMapper extends BaseMapper<Information> {

    List<InformationDTO> selectAll(InformationDTO informationDTO);
}




