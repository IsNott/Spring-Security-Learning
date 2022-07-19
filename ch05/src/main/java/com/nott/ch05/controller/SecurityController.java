package com.nott.ch05.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nott
 * @Date 2022/7/19
 */

@RestController
public class SecurityController {
    @RequestMapping("/msg")
    public String hello() {
        return "Hello Spring Security!";
    }
}
