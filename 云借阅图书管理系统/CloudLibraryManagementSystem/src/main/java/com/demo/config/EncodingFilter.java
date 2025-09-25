package com.demo.config;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.config
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-20  19:53
 * @Description: TODO
 * @Version: 1.0
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 编码拦截器
 */
@WebFilter(filterName = "encodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    /**
     * 初始化
     * 随着服务器的开启而初始化
     *
     * @param filterConfig 过滤器配置
     * @throws ServletException servlet异常
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 过滤器
     * 设置请求和响应的编码格式
     * 编码格式设置完成之后 放行 执行主代码
     *
     * @param servletRequest  servlet请求
     * @param servletResponse servlet响应
     * @param filterChain     过滤器链
     * @throws IOException      Ioexception
     * @throws ServletException servlet异常
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html; charset=utf-8");
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 摧毁
     * 随着服务器的销毁而销毁
     */
    @Override
    public void destroy() {

    }
}
