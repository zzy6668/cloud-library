package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @BelongsProject: CloudLibraryManagementSystem
 * @BelongsPackage: com.demo.config
 * @Author: 云边小屋(My.Tears)
 * @CreateTime: 2023-03-20  19:52
 * @Description: TODO
 * @Version: 1.0
 */
// 声明这是一个配置类
@Configuration
// 开启注解扫描
@ComponentScan("com.demo.service")
// 导入Mybatis和Jdbc类的数据信息
@Import({MybatisConfig.class,JdbcConfig.class})

// 开启事务管理 注解驱动
@EnableTransactionManagement
public class SpringConfig {

    // 事务管理器的配置
    @Bean
    public DataSourceTransactionManager transactionManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();

        dataSourceTransactionManager.setDataSource(dataSource);

        return dataSourceTransactionManager;
    }
}
