package com.example.demo05.mapper;

import com.example.demo05.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

// Dao层：访问数据库接口文件
@Mapper
public interface UserMapper {
    // 登录时信息核对
    UserBean getInfo(String username, String password);

    // 查询所有用户信息
    List<UserBean> queryAllUser();

    // 根据ID查询用户信息
    UserBean selectUserById(String id);

    // 插入新用户
    int insertUser(UserBean userBean);

    // 修改用户
    int updateUser(UserBean userBean);

    // 删除用户
    int deleteUser(String id);
}










