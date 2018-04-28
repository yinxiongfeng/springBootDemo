package com.example.demo.test;


import com.example.demo.config.RedisConfig;
import com.example.demo.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Created by yinxf on 2018/4/27.
 */
public class RedisTest {


    @Test
    public void test(){
        Integer a=1;
        int b=1;
        System.out.println(a==b);

        Double aa=2.0;
        double bb=2;
        System.out.println(aa==bb);

        System.out.println("Hello World!");

    }
}
