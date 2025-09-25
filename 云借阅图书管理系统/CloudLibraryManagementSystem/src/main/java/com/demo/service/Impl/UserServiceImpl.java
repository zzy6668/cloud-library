package com.demo.service.Impl;

import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.service.Impl
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-21  09:14
 * @Description: TODO
 * @Version: 1.0
 */

@Service
public class UserServiceImpl implements UserService {
    // 注入UserMapper对象
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 通过User的用户账户和用户密码查询用户信息
    @Override
    public User login(User user) {

        return userMapper.login(user);
    }
}
