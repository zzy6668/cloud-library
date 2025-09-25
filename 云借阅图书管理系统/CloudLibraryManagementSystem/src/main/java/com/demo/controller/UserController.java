package com.demo.controller;

import com.demo.domain.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.controller
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-21  09:18
 * @Description: TODO
 * @Version: 1.0
 */

/**
 * 本类实现用户登录和用户注销
 */
@Controller
public class UserController {

    // 注入UserService对象 调用它的login()方法
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping(value = "/getMain")
    public String getMain(){
        return "main";
    }

    /**
     * 用户登录
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/Login")
    public String login(User user, HttpServletRequest request) {

        try {
            // 将用户信息传给login()方法 用于校验用户输入是否正确
            User login = userService.login(user);

            /**
             * 判断用户是否输入正确 若输入错误 数据库查询不到信息 为null 跳转页面 提示用户输入错误
             * 输入正确就能查询到信息 不为null 跳转到主页
             */
            if (login != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user_session", login);
                return "redirect:/admin/main.jsp";
            }
            request.setAttribute("msg", "用户或者密码错误!");
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "系统错误!");
            return "login";

        }
    }

    /**
     * 登录注销
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/LoginOut")
    public String LoginOut(HttpSession session,HttpServletRequest request) {
        try {

            // 销毁session
            session.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","系统异常!");
            return "login";
        }
        return "login";


    }
}
