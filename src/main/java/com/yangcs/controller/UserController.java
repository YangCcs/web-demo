package com.yangcs.controller;

import com.yangcs.dto.LoginFormDTO;
import com.yangcs.dto.Result;
import com.yangcs.entity.User;
import com.yangcs.mapper.UserMapper;
import com.yangcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @GetMapping("{id}")
    public User selectById(@PathVariable Integer id) {
        return userService.selectById(id);
    }

    @GetMapping
    public List<User> selectAll() {
        return userService.selectAll();
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer userid) {
        User user = userMapper.selectById(userid);
        return Result.ok(user);
    }

    @GetMapping("/login/{phone}")
    public Result login(@PathVariable("phone") String phone) {
        String password = "200412";
        LoginFormDTO loginFormDTO = new LoginFormDTO(phone, password);
        return userService.login(loginFormDTO);
    }
}
