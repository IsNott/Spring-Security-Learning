package com.nott.ch08.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nott.ch08.entity.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author Nott
 * @Date 2022/7/22
 */

public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select * from sys_user where username = #{name}")
    SysUser selectUserByName(String name);
}
