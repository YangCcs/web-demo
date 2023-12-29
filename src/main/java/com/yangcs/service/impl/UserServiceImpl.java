package com.yangcs.service.impl;

import com.yangcs.dto.LoginFormDTO;
import com.yangcs.dto.Result;
import com.yangcs.entity.User;
import com.yangcs.mapper.UserMapper;
import com.yangcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public Result login(LoginFormDTO loginForm) {
        // 获取手机号，还应该检测手机号是否有效
        String phone = loginForm.getPhone();
        String password = loginForm.getPassword();

        // 从数据库里面通过用户手机号查找该用户
        User user = userMapper.selectByPhone(phone);

        // 判断用户是否存在
        if (user == null) {
            // 先返回个错误吧
            return Result.fail("没有查找到该用户，现在还不会创建新用户呢");
        }

        return Result.ok(user);
    }
}
