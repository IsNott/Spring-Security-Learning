package com.nott.ch08.config;

import com.nott.ch08.component.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author Nott
 * @Date 2022/7/22
 */

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;
    @Autowired
    @Qualifier("SuccessHandler")
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Bean("MyPasswordEncoder") //密码加密器
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/index", "/login.html", "/login", "/logout", "/js/**").permitAll() //放行的请求，访问的白名单
                .antMatchers("/access/user").hasAnyRole("USER", "ADMIN")    //hasAnyRole 拥有任意角色
                .antMatchers("/access/read").hasAnyRole("READ", "ADMIN", "USER")
                .antMatchers("/access/admin").hasRole("ADMIN") //hasRole拥有角色
                .anyRequest().authenticated() //其他请求需要验证
                .and()
//                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .successHandler(successHandler) //登录成功的handler
                .failureHandler(failureHandler) //登录失败的handler
                .loginPage("/login.html")   //登录的视图页面
                .loginProcessingUrl("/login") // form中登录的访问uri
                .failureUrl("/error.html") //登录失败的页面
                .permitAll()
                .and()
                .sessionManagement().disable() //关闭session
                .csrf().disable();
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index", "/login.html", "/js/**");
    }
}
