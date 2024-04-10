package com.ethereal.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ethereal.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
* @author 53609
* @description 针对表【admin(管理员)】的数据库操作Mapper
* @createDate 2024-03-26 15:36:38
* @Entity generator.domain.Admin
*/

public interface AdminMapper extends BaseMapper<Admin> {

    Admin selectByUsername(String username);

    List<Admin> selectAll(Admin admin);
}




