package com.dxc.application.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean(destroyMethod = "close")
    public DataSource appDataSource (){

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@10.254.245.76:8521:XE");
        hikariConfig.setUsername("BX0USER01");
        hikariConfig.setPassword("bx0user01espi");

        hikariConfig.setMaximumPoolSize(2);
        hikariConfig.setConnectionTestQuery("SELECT 1 FROM DUAL");
        hikariConfig.setPoolName("spring4MonitorCP");

        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }
}
