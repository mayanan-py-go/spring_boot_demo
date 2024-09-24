package com.example.demo05.bean;

import lombok.Getter;
import lombok.Setter;

// @Getter和@Setter是lombok插件库中的一个注解，用于自动生成getter和setter方法
@Setter
@Getter
public class UserBean {
    private int id;
    private String username;
    private String password;
}
