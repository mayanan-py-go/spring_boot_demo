package com.example.demo05.ServiceImpl;

import com.example.demo05.bean.UserBean;
import com.example.demo05.mapper.UserMapper;
import com.example.demo05.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// 业务实现类，注意要注解@Service，注入DAO
// @Service注解用于标记该类为服务层组件
@Service
public class UserServiceImpl implements UserService {

    // 将Dao注入到Service层
    // final表示这个变量被赋值后不能再被重新赋值，也就是说一旦通过构造函数给userMapper赋值，就不能改变它指向的对象
    private final UserMapper userMapper;
    // @Autowired: 注解表明spring将自动注入UserMapper的实现实例
    @Autowired
    // 通过构造函数进行依赖注入
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;  // 将依赖关系传入
    }

    // 登录
    @Override
    public UserBean loginIn(String username, String password) {
        return userMapper.getInfo(username, password);
    }

    // 根据ID查询用户信息
    @Override
    public UserBean queryUserById(String id) {
        return userMapper.selectUserById(id);
    }

    // 查询所有用户信息
    @Override
    public List<UserBean> queryAllUser() {
        return userMapper.queryAllUser();
    }

    // 新增用户
    @Override
    public int addUser(UserBean userBean) {
        return userMapper.insertUser(userBean);
    }

    // 修改用户
    @Override
    public int updateUser(UserBean userBean) {
        return userMapper.updateUser(userBean);
    }

    // 删除用户
    @Override
    public int deleteUser(String id) {
        return userMapper.deleteUser(id);
    }

}


