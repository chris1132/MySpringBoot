package com.boot1.config.datasource.mysql;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
public class DataSourceContextHolder {
    public static final String DEFAULT_DS = "chovyDataSource";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // ��������Դ��
    public static void setDB(String dbType){
        System.out.println("�л���{"+dbType+"}����Դ");
        contextHolder.set(dbType);
    }
    // ��ȡ����Դ��
    public static String getDB() {
        return (contextHolder.get());
    }

    // �������Դ��
    public static void clearDB() {
        contextHolder.remove();
    }
}
