package com.example.demo05.controller;

import com.example.demo05.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.demo05.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @Controller标记该类为SpringMVC中的控制器组件
// 控制器负责接收用户输入，调用服务层的业务逻辑并返回视图
@Controller
public class LoginController {
    // 将Service注入web层
    // 通过构造函数进行依赖注入的优点：
    // 1. 可替换性：可以替换掉UserService的实现类，而不需要修改LoginController类
    // 2. 更清晰的依赖关系：构造函数清晰的表明了这个类依赖的其他组件
    // 3. 提高可维护性：代码更易于维护，因为所有依赖都集中于构造函数中，便于修改和理解
    // 总结：通过构造函数进行依赖注入是一种有效的设计方式
    private final UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value="/loginIn", method = RequestMethod.POST)
    public String login(String username, String password) {
        UserBean userBean = userService.loginIn(username, password);
        if (userBean != null) {
            return "success";
        } else {
            return "error";
        }
    }
}






