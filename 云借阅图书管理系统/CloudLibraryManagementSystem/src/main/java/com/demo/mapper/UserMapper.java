package com.demo.mapper;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 用户登录验证接口
 */
public interface UserMapper {
    /**
     * 根据用户账号和密码查询用户信息
     */
    @Select("select * from user where user_email=#{email} and user_password=#{password} and user_status!='1'")
    @Results(id = "userResult", value = {
            // id=true 表示为主键 column表示数据库字段 property表示持久层的属性名称
            @Result(id = true, column = "user_id", property = "id"),
            @Result(column = "user_name", property = "name"),
            @Result(column = "user_password", property = "password"),
            @Result(column = "user_email", property = "email"),
            @Result(column = "user_role", property = "role"),
            @Result(column = "user_status", property = "status")
    })
    User login(User user);
}
