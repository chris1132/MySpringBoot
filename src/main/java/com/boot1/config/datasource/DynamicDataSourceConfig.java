package com.boot1.config.datasource;

import com.boot1.config.datasource.mysql.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfig {

    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource( @Qualifier("chovyDataSource") DataSource chovyDataSource,
                                         @Qualifier("chrisDataSource") DataSource chrisDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(chovyDataSource);
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("chovyDataSource", chovyDataSource);
        dsMap.put("chrisDataSource", chrisDataSource);

        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

}
