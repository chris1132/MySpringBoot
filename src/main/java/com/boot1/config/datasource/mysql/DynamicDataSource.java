package com.boot1.config.datasource.mysql;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Deprecated
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为"+DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
