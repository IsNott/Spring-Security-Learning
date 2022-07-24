package com.nott.ch08.component;

import com.alibaba.fastjson.JSONObject;
import com.nott.ch08.common.Result;
import com.nott.ch08.entity.SysUser;
import com.nott.ch08.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component("SuccessHandler")
public class SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtUtils jwtUtils;

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
        SysUser user = (SysUser) authentication.getPrincipal();
        String token = jwtUtils.createToken(user.getUsername());
        Result result = Result.successData(token);
        httpServletResponse.setCharacterEncoding("utf-8");//修改编码格式
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(result));//输出结果
        //httpServletResponse.sendRedirect("/index");
    }
}
