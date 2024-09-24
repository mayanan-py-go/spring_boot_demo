package com.example.demo05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo05.service.UserService;
import com.example.demo05.bean.UserBean;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ModifyUserController {
    private final UserService userService;

    @Autowired
    public ModifyUserController(UserService userService) {
        this.userService = userService;
    }

    // 查询所有用户信息
    @RequestMapping("/users")
    public String showUsers(ModelMap modelMap) {
        List<UserBean> userList = userService.queryAllUser();
        modelMap.addAttribute("userList", userList);
        return "users";
    }

    // 新增用户
    @RequestMapping("/addUser")
    @ResponseBody
    public Map addUser(UserBean userBean) {
        int flag = userService.addUser(userBean);
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag == 1) {
            map.put("msg", "新增用户成功");
            return map;
        } else {
            map.put("msg", "新增用户失败");
            return map;
        }
    }

    // 根据ID查询用户信息
    @RequestMapping("/user/{id}")
    public String queryUserById(@PathVariable String id, ModelMap modelMap) {
        UserBean userBean = userService.queryUserById(id);
        modelMap.addAttribute("user", userBean);
        return "userInfo";
    }

    // 修改用户信息
    @RequestMapping("/modifyUser")
    @ResponseBody
    public Map updateUser(UserBean userBean) {
        int flag = userService.updateUser(userBean);
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag == 1) {
            map.put("msg", "修改用户成功");
            return map;
        } else {
            map. put("msg", "修改用户失败");
            return map;
        }
    }

    // 删除用户
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id, ModelMap modelMap) {
        int flag = userService.deleteUser(id);
        List<UserBean> userList = userService.queryAllUser();
        modelMap.addAttribute("userList", userList);
        if (flag == 1) {
            return "users";
        } else {
            return "error";
        }
    }
}




