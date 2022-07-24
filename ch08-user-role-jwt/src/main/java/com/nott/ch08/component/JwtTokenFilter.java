package com.nott.ch08.component;

import com.mysql.cj.util.StringUtils;
import com.nott.ch08.service.UserService;
import com.nott.ch08.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
//        if (!httpServletRequest.getRequestURI().matches("login")) {
        String token = httpServletRequest.getHeader(this.tokenHeader);
        if (!StringUtils.isNullOrEmpty(token)) {
            String username = jwtUtils.getBody(token).getSubject();
            if (username == null) {
                throw new RuntimeException("Username missing");
            }
            if (SecurityContextHolder.getContext().getAuthentication() != null) {
                logger.info("username: " + username);
                UserDetails userDetails = userService.loadUserByUsername(username);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    logger.info("userDetails: " + authenticationToken.getPrincipal());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }

            }
//            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
