package com.demo.config;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.config
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-20  19:52
 * @Description: TODO
 * @Version: 1.0
 */

import com.demo.interceptor.ResourceInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * Spring Mvc 相关的配置类
 */
@Configuration
/**
 * 引入普通用户可以访问的资源配置文件
 */
@PropertySource("classpath:ignoreUrl.properties")
@ComponentScan("com.demo.controller")
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    // 获取ignoreUrl值 将里面的地址字符串分割 并注入信息
    @Value("#{'${ignoreUrl}'.split(',')}")
    private List<String> ignoreUrl;



    @Bean
    public ResourceInterceptor resourceInterceptor(){
        return new ResourceInterceptor(ignoreUrl);
    }

    /**
     * 开启静态资源释放
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        registry.jsp("/admin/", ".jsp");
    }

    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 添加拦截器 并添加拦截路径(所有路径)以及排除静态路径
        registry.addInterceptor(new ResourceInterceptor(ignoreUrl)).addPathPatterns("/**").excludePathPatterns("/css/**", "/img/**", "/js/**");
    }
}

