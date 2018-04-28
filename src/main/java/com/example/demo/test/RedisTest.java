package com.example.demo.test;


import com.example.demo.config.RedisConfig;
import com.example.demo.utils.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Created by yinxf on 2018/4/27.
 */
public class RedisTest {

    @Autowired
    private RedisConfig redisConfig;


    @Test
    public void test(){
        JedisConnectionFactory foctory =  redisConfig.JedisConnectionFactory(redisConfig.jedisPoolConfig());
        RedisUtil util = redisConfig.redisUtil(redisConfig.functionDomainRedisTemplate(foctory));

        util.set("name","张三");
        System.out.println(util.get("name"));

    }
}
