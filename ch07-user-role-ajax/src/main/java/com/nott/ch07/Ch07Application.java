package com.nott.ch07;


import org.mybatis.spring.annotation.MapperScan;

import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan({"com.nott.*.mapper"})
public class Ch07Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch07Application.class, args);
    }


}