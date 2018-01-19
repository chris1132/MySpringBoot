package com.boot1.common.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by wangchaohui on 2018/1/19.
 */

@Configuration
@MapperScan(basePackages = "com.boot1.chris.mapper",sqlSessionTemplateRef = "chrisSqlSessionTemplate")
@PropertySource(value = "classpath:datasource.properties")
public class ChrisDataSourceConfig {

    @Bean(name="chrisDataSource")
    @ConfigurationProperties(prefix="spring.datasource.chris")
    public DataSource chrisDataSource() throws Exception{
        return DataSourceBuilder.create().build();
    }

    @Bean(name="chrisSqlSessionFactory")
    public SqlSessionFactory chrisSqlSessionFactory(@Qualifier("chrisDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="chrisSqlSessionTemplate")
    public SqlSessionTemplate chrisSqlSessionTemplate(@Qualifier("chrisSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name="chrisTransaction")
    public DataSourceTransactionManager chrisTransaction(@Qualifier("chrisDataSource") DataSource dataSource) throws Exception{
        return new DataSourceTransactionManager(dataSource);
    }
}
