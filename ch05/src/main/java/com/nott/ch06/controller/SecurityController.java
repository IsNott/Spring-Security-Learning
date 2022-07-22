package com.nott.ch06.controller;

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
