package com.nott.ch06.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nott.ch06.entity.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Nott
 * @Date 2022/7/22
 */


public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT sr.id ,sr.rolename rolename,sr.rolememo rolememo FROM " +
            "sys_user_role sur,sys_user su,sys_role sr " +
            "WHERE sur.userid = su.id AND sur.roleid = sr.id AND su.id = #{id}")
    List<SysRole> selectRoleById(Long id);
}
