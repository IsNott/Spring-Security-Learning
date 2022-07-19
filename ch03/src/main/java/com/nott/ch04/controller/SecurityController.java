package com.nott.ch04.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nott
 * @Date 2022/7/19
 */

@RestController
@RequestMapping("ss")
public class SecurityController {

    @RequestMapping("msg")
    public String hello() {
        return "Hello User from memory!";
    }

    @RequestMapping("user")
    @PreAuthorize(value = "hasAnyRole('admin','normal')") //访问方法前进行验证
    public String testRole() {
        return hello();
    }

    @RequestMapping("admin")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String testAdminRole() {
        return "hello Admin!";
    }


}
