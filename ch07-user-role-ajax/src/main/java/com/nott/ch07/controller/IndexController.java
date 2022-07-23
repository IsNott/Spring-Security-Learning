package com.nott.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Nott
 * @Date 2022/7/22
 */


@Controller
public class IndexController {

    @RequestMapping("/index")
    public String toIndex() {
        return "forward:/index.html";
    }
}
