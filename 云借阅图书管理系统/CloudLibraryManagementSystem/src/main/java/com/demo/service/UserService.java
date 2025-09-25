package com.demo.service;

import com.demo.domain.User;

/**
 * 用户接口
 */
public interface UserService {
    // 根据用户的账号和密码查询用户信息
    User login(User user);

}
