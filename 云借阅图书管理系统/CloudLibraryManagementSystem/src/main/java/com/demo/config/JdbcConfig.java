package com.demo.config;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.config
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-20  19:51
 * @Description: TODO
 * @Version: 1.0
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 用于读取数据库连接信息的配置类
 */

// 引入外部数据库源
@PropertySource("classpath:db.properties")
public class JdbcConfig {

    /**
     * 通过@Value传入数据
     */
    @Value("${DriverManager}")
    private String driverClassName;
    @Value("${jdbcUrl}")
    private String JdbcUrl;
    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;

    // 注册Bean==Spring中的bean
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        // 数据库驱动
        druidDataSource.setDriverClassName(driverClassName);
        // 连接数据的地址
        druidDataSource.setUrl(JdbcUrl);
        // 数据库账户
        druidDataSource.setUsername(username);
        // 数据库密码
        druidDataSource.setPassword(password);

        return druidDataSource;
    }
}
