package com.ethereal.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethereal.pojo.Notice;

import java.util.List;

/**
* @author 53609
* @description 针对表【notice(公告信息表)】的数据库操作Mapper
* @createDate 2024-03-26 15:36:38
* @Entity generator.domain.Notice
*/
public interface NoticeMapper extends BaseMapper<Notice> {
    List<Notice> selectAll(Notice notice);
}




