package com.example.demo05.service;

import com.example.demo05.bean.UserBean;

import java.util.List;

// 业务接口类
public interface UserService {
    // 登录时信息核对
    UserBean loginIn(String username, String password);

    // 查询所有用户信息
    List<UserBean> queryAllUser();

    // 更具ID查询用户信息
    UserBean queryUserById(String id);

    // 插入新用户
    int addUser(UserBean userBean);

    // 修改用户
    int updateUser(UserBean userBean);

    // 删除用户
    int deleteUser(String id);
}







