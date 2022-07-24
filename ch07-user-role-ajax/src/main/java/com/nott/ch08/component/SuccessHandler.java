package com.nott.ch08.component;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    /**
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @param authentication      security框架验证用户信息成功的封装类
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //登录用户信息验证成功后执行的方法
        httpServletResponse.setContentType("application/json;charset:utf-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("{'msg':'login success..'}");
        printWriter.flush();
        printWriter.close();
    }
}
