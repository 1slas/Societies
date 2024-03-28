package com.ethereal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ethereal.pojo.DTO.InformationDTO;
import com.ethereal.pojo.Information;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
* @author 53609
* @description 针对表【information(社团资讯表)】的数据库操作Service
* @createDate 2024-03-26 15:36:38
*/
public interface InformationService extends IService<Information> {

    void add(Information information);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    InformationDTO selectById(Integer id);

    List<InformationDTO> selectAll(InformationDTO informationDTO);

    PageInfo<InformationDTO> selectPage(InformationDTO informationDTO, Integer pageNum, Integer pageSize);
}
