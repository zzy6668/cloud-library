package com.demo.config;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.config
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-20  19:52
 * @Description: TODO
 * @Version: 1.0
 */

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Mybatis相关的配置类
 */
// mapper的映射包扫描
@MapperScan("com.demo.mapper")
public class MybatisConfig {

    // 配置分页插件拦截器
    @Bean
    public PageInterceptor getPageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();

        // 分页插件配置
        Properties properties = new Properties();
        // 开启
        properties.setProperty("value", "true");
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }

    /**
     * 定义Mybatis的核心连接Bean datasource使用自动装配
     */

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource dataSource,@Autowired PageInterceptor pageInterceptor){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 将数据源信息给构建工厂
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 将分页拦截器插件交给Mybatis
        Interceptor[] interceptors = {pageInterceptor};
        sqlSessionFactoryBean.setPlugins(interceptors);
        // 定义包别名扫描
        sqlSessionFactoryBean.setTypeAliasesPackage("com.demo.domain");

        return sqlSessionFactoryBean;


    }



}


