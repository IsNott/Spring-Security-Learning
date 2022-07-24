package com.nott.ch08.service;


import com.nott.ch08.entity.SysRole;
import com.nott.ch08.entity.SysUser;
import com.nott.ch08.mapper.SysRoleMapper;
import com.nott.ch08.mapper.SysUserMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nott
 * @Date 2022/7/22
 */

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
//    @Qualifier("sysUserMapper")
    private SysUserMapper sysUserMapper;
    @Autowired
//    @Qualifier("sysRoleMapper")
    private SysRoleMapper sysRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //1.获取用户信息
        SysUser sysUser = sysUserMapper.selectUserByName(s);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        log.info("Found user: " + sysUser.toString());
        //2.根据用户信息获取角色信息
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<SysRole> roles = sysRoleMapper.selectRoleById(sysUser.getId());
        if (!CollectionUtils.isEmpty(roles)) {
            log.info("User's role: " + roles.toString());
            for (SysRole sysRole : roles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + sysRole.getRolename());
                authorities.add(authority);
            }
        }
        sysUser.setAuthorities(authorities); //用户权限
        return sysUser;
    }
}
