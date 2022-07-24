package com.nott.ch08.component;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class FailureHandler implements AuthenticationFailureHandler {
    /**
     *
     * @param httpServletRequest 请求
     * @param httpServletResponse 响应
     * @param authenticationException security框架验证用户信息成功的封装类
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authenticationException) throws IOException, ServletException {
        //登录用户信息验证失败后执行的方法

    }
}
