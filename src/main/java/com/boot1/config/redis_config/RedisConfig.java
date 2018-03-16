package com.boot1.config.redis_config;

import com.boot1.redis.RedisPropertiesBean;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;


/**
 * Created by wangchaohui on 2018/3/2.
 */

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
//
//    public static Logger logger = LoggerFactory.getLogger(RedisConfig.class);
//    @Bean
//    @ConfigurationProperties(prefix="spring.redis")
//    public JedisPoolConfig getRedisConfig(){
//        JedisPoolConfig config = new JedisPoolConfig();
//        return config;
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix="spring.redis")
//    public JedisConnectionFactory getConnectionFactory(){
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        JedisPoolConfig config = getRedisConfig();
//        factory.setPoolConfig(config);
//        logger.info("JedisConnectionFactory bean init success.");
//        return factory;
//    }
//
//    @Bean
//    public RedisTemplate<?, ?> getRedisTemplate(){
//        RedisTemplate<?,?> template = new StringRedisTemplate(getConnectionFactory());
//        return template;
//    }

    @Autowired
    private RedisPropertiesBean redisPropertiesBean;
    /**
     * 生成key的策略
     *
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }

    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        /**设置缓存过期时间 */
        cacheManager.setDefaultExpiration(60);
//        Map<String,Long> map=new HashMap<String, Long>();
//        map.put("expire",60L);
//        cacheManager.setExpires(map);
        return cacheManager;
    }

    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate template = new StringRedisTemplate(factory);
        /**设置序列化工具*/
        setSerializer(template);
        template.afterPropertiesSet();
        return template;
    }

    private void setSerializer(StringRedisTemplate temple){
        @SuppressWarnings({"rawtypes","unchecked"})
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        temple.setValueSerializer(jackson2JsonRedisSerializer);
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisPropertiesBean.getHost());
        factory.setPort(redisPropertiesBean.getPort());
        factory.setPassword(redisPropertiesBean.getPassword());
        factory.setTimeout(redisPropertiesBean.getTimeout()); //设置连接超时时间
        return factory;
    }


}
