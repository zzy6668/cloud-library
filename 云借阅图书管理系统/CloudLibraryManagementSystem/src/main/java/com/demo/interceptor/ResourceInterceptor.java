package com.demo.interceptor;

import com.demo.domain.User;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Properties;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.interceptor
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-21  18:11
 * @Description: TODO
 * @Version: 1.0
 */
public class ResourceInterceptor implements HandlerInterceptor {

    private List<String> ignoreUrl;

    public ResourceInterceptor(List<String> ignoreUrl) {
        this.ignoreUrl = ignoreUrl;
    }


    /**
     * 拦截器
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 1. 判断用户是否已经登录 若已经登录放行
         * 2. 判断用户是否请求的是登录 若是 放行（不拦截该页面，用户需要登录）
         * 3. 若没有登录 也没有请求登录不放行
         */

        // 获取请求地址
        String requestURI = request.getRequestURI();


        // 用户和管理员访问登录页面 都放行 判断请求地址是否包含login 若包含并且大于0 就放行
        if (requestURI.indexOf("Login") > 0) {
            return true;
        }


        // 获取session
        User attribute = (User) request.getSession().getAttribute("user_session");


        // 判断session是否为空 为空 就说明未登录
        if (attribute != null) {

            // 判断用户是否为管理员
            if ("ADMIN".equals(attribute.getRole())) {

                // 管理员放行
                return true;

            } else {

                // 不是管理员 普通用户需要判断请求的是否访问 ignoreUrl里面的参数是允许普通用户访问的url地址
                for (String url : ignoreUrl) {
                    if (requestURI.indexOf(url) > 0) {
                        return true;
                    }
                }
                // 提示普通用户不是管理员
                request.setAttribute("msg", "抱歉,您不是管理员没有权限修改图书信息!");
                request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
                return false;
            }


        }

        // 跳转到登录页面
        request.setAttribute("msg", "您还未登录,请先登录!");
        request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        return false;
    }


}
