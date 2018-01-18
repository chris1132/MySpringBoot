package com.chovy.common.datasource;

/**
 * Created by wangchaohui on 2018/1/18.
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<DatabaseType>();

    public static DatabaseType getDatabaseType(){
        return contextHolder.get();
    }

    public static void setDatabaseType(DatabaseType type){
        contextHolder.set(type);
    }
}
