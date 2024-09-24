package com.example.demo05;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 项目启动类要添加注解@MapperScan，项目启动时扫描mapper接口，否则会报错找不到mapper文件
@SpringBootApplication
@MapperScan("com.example.demo05.mapper")
public class Demo05Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo05Application.class, args);
    }

}
