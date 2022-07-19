package com.nott.ch04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//排查Security配置，关闭验证
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class Ch03Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch03Application.class, args);
    }

}
