package com.yangcs.service;

import com.yangcs.dto.LoginFormDTO;
import com.yangcs.dto.Result;
import com.yangcs.entity.User;

import java.util.List;

public interface UserService {
    User selectById(Integer id);
    List<User> selectAll();
    Result login(LoginFormDTO loginForm);
}
