package com.ethereal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.mapper.NoticeMapper;
import com.ethereal.service.NoticeService;
import generator.domain.Notice;
import org.springframework.stereotype.Service;

/**
* @author 53609
* @description 针对表【notice(公告信息表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService {

}




