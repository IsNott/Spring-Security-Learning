package com.nott.ch07.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nott.ch07.entity.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author Nott
 * @Date 2022/7/22
 */

public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select * from sys_user where username = #{name}")
    SysUser selectUserByName(String name);
}
