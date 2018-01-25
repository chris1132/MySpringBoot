package com.boot2.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by wangchaohui on 2018/1/19.
 */
@Configuration
@MapperScan(basePackages = "com.boot2.chovy.persistent",sqlSessionTemplateRef = "chovySqlSessionTemplate")
@PropertySource(value = "classpath:datasource.properties")
public class ChovyDataSourceConfig {

    @Bean(name = "chovyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.chovy")
    @Primary
    public DataSource chovyDataSource() throws Exception{
        return DataSourceBuilder.create().build();
    }

    @Bean(name="chovySqlSessionFactory")
    @Primary
    public SqlSessionFactory chovySqlSessionFactory(@Qualifier("chovyDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/chovy/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="chovySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate chovySqlSessionTemplate(@Qualifier("chovySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Primary
    public DataSourceTransactionManager chovyTransactionManager(@Qualifier("chovyDataSource") DataSource dataSource) throws Exception{
        return new DataSourceTransactionManager(dataSource);
    }
}
