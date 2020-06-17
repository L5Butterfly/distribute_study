package com.oxygen.example.springbootstarterdemo.jdbcdemo;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


/**
 * JdbcDataSourceConfig 多数据源配置
 * @author oxygen
 * @date 2020/6/16
 **/
@Configuration
public class JdbcDataSourceConfig {

    /**
     * 根据配置文件加载构建数据源
     * @return
     */
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "app.datasource.db1")
    public DataSourceProperties db1DataSourceProperties(){
        return new DataSourceProperties();
    }


    /**
     * 根据配置文件加载构建数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "app.datasource.db2")
    public DataSourceProperties db2DataSourceProperties(){
        return new DataSourceProperties();
    }


    /**
     * 根据数据库配置构建数据源链接
     * @return
     */
    @Primary
    @Bean
    public DataSource db1DataSource(){
        return db1DataSourceProperties().initializeDataSourceBuilder().build();
    }


    /**
     * 根据数据库配置构建数据源链接
     * @return
     */
    @Bean
    public DataSource db2DataSource(){
        return db2DataSourceProperties().initializeDataSourceBuilder().build();
    }


    /**
     * 数据源1
     * @return
     */
    @Bean(name="db1JdbcTemplate")
    public JdbcTemplate db1JdbcTemplate(){
        return new JdbcTemplate(db1DataSource());
    }

    /**
     * 数据源2
     * @return
     */
    @Bean(name="db2JdbcTemplate")
    public JdbcTemplate db2JdbcTemplate(){
        return new JdbcTemplate(db2DataSource());
    }



}
