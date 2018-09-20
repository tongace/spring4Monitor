package com.dxc.application.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan("com.dxc.application.mybatis.mapper")
@ComponentScan(basePackages = "com.dxc.application")
public class DatabaseConfig {

    @Bean
    public DataSource appDataSource (){

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@10.254.245.76:8521:XE");
        hikariConfig.setUsername("BX0USER01");
        hikariConfig.setPassword("bx0user01espi");

        hikariConfig.setMaximumPoolSize(2);
        hikariConfig.setConnectionTestQuery("SELECT 1 FROM DUAL");
        hikariConfig.setPoolName("spring4MonitorCP");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(appDataSource());
        SqlSessionFactory sessionFactory = sessionFactoryBean.getObject();
        sessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory;
    }
    @Bean
    public PlatformTransactionManager transactionalManager() {
        return new DataSourceTransactionManager(appDataSource());
    }
}
