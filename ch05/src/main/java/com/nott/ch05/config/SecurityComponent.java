package com.nott.ch05.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Nott
 * @Date 2022/7/19
 */

@Configuration
public class SecurityComponent {
    //配置密码加密
    @Bean("myPasswordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //创建userDetailsService
    @Bean("myUserDetailsService")
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //创建用户
        manager.createUser(User.withUsername("nott")
                .password(passwordEncoder()
                        .encode("123"))
                .roles("ADMIN", "USER").build());
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder()
                        .encode("123"))
                .roles("USER").build());
        return manager;
    }
}
