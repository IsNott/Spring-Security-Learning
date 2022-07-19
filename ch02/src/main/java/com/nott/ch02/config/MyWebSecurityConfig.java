package com.nott.ch02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * @author Nott
 * @Date 2022/7/19
 */
//使用内存中的用户信息
@Configuration //配置类=Spring的Xml
@EnableWebSecurity // 启用SpringSecurity安全框架
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {


    //在方法中配置用户密码，作为登录信息
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication().withUser("nott").password(encoder.encode("123")).roles();
        auth.inMemoryAuthentication().withUser("nott1").password(encoder.encode("123")).roles();
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("123")).roles();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //配置密码加密器,SpringSecurity5后需要配置
        return new BCryptPasswordEncoder();
    }
}
