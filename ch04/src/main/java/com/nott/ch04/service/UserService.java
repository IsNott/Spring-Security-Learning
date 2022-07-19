package com.nott.ch04.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nott.ch04.entity.User;
import com.nott.ch04.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nott
 * @Date 2022/7/19
 */

@Service(value = "userService")
public class UserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;
    @Autowired
    @Qualifier("myPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, s);
        List<User> list = userMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new UsernameNotFoundException("User not Found!");
        }
        User user = list.get(0);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        //角色须以ROLE_开头
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());
        authorities.add(authority);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), passwordEncoder.encode(user.getPassword()), authorities);
    }
}
