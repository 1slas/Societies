package com.ethereal.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ethereal.mapper.NoticeMapper;
import com.ethereal.pojo.Account;
import com.ethereal.pojo.Notice;
import com.ethereal.service.NoticeService;
import com.ethereal.untils.Token;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 53609
* @description 针对表【notice(公告信息表)】的数据库操作Service实现
* @createDate 2024-03-26 15:36:38
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;
    /**
     * @param notice:
      * @return void
     * @author 53609
     * @description 新增公告
     * @date 2024/3/28 17:30
     */
    @Override
    public void add(Notice notice) {
        notice.setTime(DateUtil.today());
        Account currentUser = Token.getCurrentUser();
        notice.setUser(currentUser.getUsername());
        noticeMapper.insert(notice);
    }
    /**
     * @param id:
      * @return void
     * @author 53609
     * @description 删除公告
     * @date 2024/3/28 17:37
     */
    @Override
    public void deleteById(Integer id) {
        noticeMapper.deleteById(id);
    }
    /**
     * @param ids:
      * @return void
     * @author 53609
     * @description 批量删除
     * @date 2024/3/28 17:40
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids){
            noticeMapper.deleteById(id);
        }
    }
    /**
     * @param id:
      * @return Notice
     * @author 53609
     * @description 根据id查询
     * @date 2024/3/28 17:54
     */
    @Override
    public Notice selectById(Integer id) {
        return noticeMapper.selectById(id);
    }
    /**
     * @param notice:
      * @return List<Notice>
     * @author 53609
     * @description 获取列表信息
     * @date 2024/3/28 17:56
     */
    @Override
    public List<Notice> selectAll(Notice notice) {
        return noticeMapper.selectAll(notice);
    }
    /**
     * @param notice:
    	 * @param pageNum:
    	 * @param pageSize:
      * @return PageInfo<Notice>
     * @author 53609
     * @description 分页查询
     * @date 2024/3/28 18:01
     */
    @Override
    public PageInfo<Notice> selectPage(Notice notice, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Notice> list = noticeMapper.selectAll(notice);
        return PageInfo.of(list);
    }
}




