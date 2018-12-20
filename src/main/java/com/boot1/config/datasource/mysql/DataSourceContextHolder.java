package com.boot1.config.datasource.mysql;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
public class DataSourceContextHolder {
    public static final String DEFAULT_DS = "chovyDataSource";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源名
    public static void setDB(String dbType){
        System.out.println("切换到{"+dbType+"}数据源");
        contextHolder.set(dbType);
    }
    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
