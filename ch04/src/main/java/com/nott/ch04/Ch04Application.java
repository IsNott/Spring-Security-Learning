package com.nott.ch04;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//排查Security配置，关闭验证
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
@MapperScan("com.nott.*.mapper")
public class Ch04Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch04Application.class, args);
    }

}
