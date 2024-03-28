package com.ethereal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ethereal.pojo.Notice;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
* @author 53609
* @description 针对表【notice(公告信息表)】的数据库操作Service
* @createDate 2024-03-26 15:36:38
*/
public interface NoticeService extends IService<Notice> {

    void add(Notice notice);
    void deleteById(Integer id);
    void deleteBatch(List<Integer> ids);

    Notice selectById(Integer id);

    List<Notice> selectAll(Notice notice);

    PageInfo<Notice> selectPage(Notice notice, Integer pageNum, Integer pageSize);
}
