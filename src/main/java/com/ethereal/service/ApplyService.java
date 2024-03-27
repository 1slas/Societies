package com.ethereal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ethereal.pojo.Apply;
import com.ethereal.pojo.DTO.ApplyDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
* @author 53609
* @description 针对表【apply(申请审批表)】的数据库操作Service
* @createDate 2024-03-26 15:36:38
*/
public interface ApplyService extends IService<Apply> {

    void add(Apply apply);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    Apply selectById(Integer id);

    List<ApplyDTO> selectAll(ApplyDTO applyDTO);

    List<ApplyDTO> selectMyApply(ApplyDTO applyDTO);
    void extracted(ApplyDTO applyDTO);

    PageInfo<ApplyDTO> selectPage(ApplyDTO applyDTO, Integer pageNum, Integer pageSize);
}
