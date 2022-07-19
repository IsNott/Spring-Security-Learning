package com.nott.ch04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Nott
 * @Date 2022/7/19
 */
//使用内存中的用户信息，使用基于角色的认证
@Configuration //配置类=Spring的Xml
@EnableWebSecurity // 启用SpringSecurity安全框架
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启基于方法级别的认证，prePostEnabled= true开启@PreAuthorize和@PostAuthorize
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {


    //在方法中配置用户密码，作为登录信息
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = passwordEncoder();
        //定义角色信息 normal admin
        auth.inMemoryAuthentication().withUser("nott").password(encoder.encode("123")).roles("normal");
        auth.inMemoryAuthentication().withUser("nott1").password(encoder.encode("123")).roles("normal");
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("123")).roles("admin","normal");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //配置密码加密器,SpringSecurity5后需要配置
        return new BCryptPasswordEncoder();
    }
}
