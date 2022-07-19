package com.nott.ch02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//排查Security配置，关闭验证
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class Ch02Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch02Application.class, args);
    }

}
