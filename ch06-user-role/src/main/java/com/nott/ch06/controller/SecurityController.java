package com.nott.ch06.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nott.ch06.entity.SysUser;
import com.nott.ch06.mapper.SysUserMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Nott
 * @Date 2022/7/19
 */

@RestController
public class SecurityController {

    @Resource
    private SysUserMapper sysUserMapper;

    @RequestMapping("/msg")
    public String hello() {
        return "Hello Spring Security!";
    }

    @RequestMapping("/user")
    public String insert() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return new SimpleGrantedAuthority("ROLE_" + "USER").getAuthority();
            }
        });
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        SysUser user = new SysUser(null, "user", "user", encoder.encode("nott"), true, true, true, true, new Date(), new Date(), list);
        sysUserMapper.insert(user);
        return "ok";
    }

    @RequestMapping("/access/user")
    public String helloUser() {
        return "Hello user from system!";
    }

    @RequestMapping("/access/admin")
    public String helloAdmin() {
        return "Hello admin from system!";
    }

    @RequestMapping("/access/read")
    public String helloUserRead() {
        return "Hello readUser from system!";
    }
}
