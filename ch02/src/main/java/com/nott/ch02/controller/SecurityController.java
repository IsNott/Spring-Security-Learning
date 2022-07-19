package com.nott.ch02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nott
 * @Date 2022/7/19
 */

@RestController
@RequestMapping("/ss")
public class SecurityController {

    @RequestMapping("/msg")
    public String hello() {
        return "Hello User from memory!";
    }
}
