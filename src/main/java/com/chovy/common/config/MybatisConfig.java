package com.chovy.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import com.chovy.common.datasource.DatabaseType;
import com.chovy.common.datasource.DynamicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by wangchaohui on 2018/1/18.
 */

@Configuration
@MapperScan(basePackages = "com.chovy.chovy.mapper")
public class MybatisConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource chovyDataSource() throws Exception{
        Properties props = new Properties();
        props.put("driverClassName",env.getProperty("chovy.datasource.driverClassName"));
        props.put("url", env.getProperty("chovy.datasource.url"));
        props.put("username", env.getProperty("chovy.datasource.username"));
        props.put("password", env.getProperty("chovy.datasource.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }
    @Bean
    public DataSource chrisDataSource() throws Exception{
        Properties props = new Properties();
        props.put("driverClassName",env.getProperty("chriswang.datasource.driverClassName"));
        props.put("url", env.getProperty("chriswang.datasource.url"));
        props.put("username", env.getProperty("chriswang.datasource.username"));
        props.put("password", env.getProperty("chriswang.datasource.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("chovyDataSource") DataSource chovyDataSource,
                                        @Qualifier("chrisDataSource") DataSource chrisDataSource){
        Map<Object,Object> targetDataSource = new HashMap<Object, Object>();
        targetDataSource.put(DatabaseType.chovy,chovyDataSource);
        targetDataSource.put(DatabaseType.chris_wang,chrisDataSource);
        DynamicDataSource datasource = new DynamicDataSource();
        datasource.setTargetDataSources(targetDataSource);
        datasource.setDefaultTargetDataSource(chovyDataSource);
        return datasource;
    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception{
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
//        sqlSessionFactoryBean.setTypeAliases(env.getProperty("mybatis.typeAliasesPackage"));
//        sqlSessionFactoryBean.setMapperLocations( new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
//        return sqlSessionFactoryBean.getObject();
//    }
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
