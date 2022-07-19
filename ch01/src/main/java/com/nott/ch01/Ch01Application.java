package com.nott.ch01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//排查Security配置，关闭验证
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class Ch01Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch01Application.class, args);
    }

}
