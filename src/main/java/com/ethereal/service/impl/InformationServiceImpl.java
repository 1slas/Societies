package com.ethereal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.mapper.InformationMapper;
import com.ethereal.service.InformationService;
import generator.domain.Information;
import org.springframework.stereotype.Service;

/**
* @author 53609
* @description 针对表【information(社团资讯表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information>
    implements InformationService {

}




