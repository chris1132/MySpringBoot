package com.boot1.config.datasource.aop;

import com.boot1.config.datasource.mysql.DS;
import com.boot1.config.datasource.mysql.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Deprecated
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(com.boot1.config.datasource.mysql.DS)")
    public void beforeSwitchDS(JoinPoint joinPoint){
        Class<?> className = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Class[] argClass = ((MethodSignature)joinPoint.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;

        try{
            Method method = className.getMethod(methodName,argClass);
            // �ж��Ƿ����@DSע��
            if (method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                // ȡ��ע���е�����Դ��
                dataSource = annotation.value();
            }
        }catch(NoSuchMethodException e){

        }
        DataSourceContextHolder.setDB(dataSource);
    }
    @After("@annotation(com.boot1.config.datasource.mysql.DS)")
    public void afterSwitchDS(JoinPoint joinPoint){
        DataSourceContextHolder.clearDB();
    }

}
