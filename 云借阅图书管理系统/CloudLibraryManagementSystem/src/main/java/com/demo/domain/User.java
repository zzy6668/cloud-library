package com.demo.domain;

import java.io.Serializable;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.domain
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-21  08:51
 * @Description: TODO
 * @Version: 1.0
 */
public class User implements Serializable {
    // 用户id
    private Integer id;
    // 用户名称
    private String name;
    // 用户密码
    private String password;
    // 用户邮箱(用户账号)
    private String email;
    // 用户角色
    private String role;
    // 用户状态
    private String status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
