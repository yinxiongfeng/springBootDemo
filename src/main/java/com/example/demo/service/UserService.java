package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Person;
import com.example.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinxf on 2018/4/18.
 */
@Service
public class UserService implements UserMapper{
    @Autowired
    UserMapper userMapper;

    @Override
    public Person selectUser(int id) {
        return userMapper.selectUser(id);
    }

    public void testRedis(RedisUtil util) {
        List<Person> list=new ArrayList<>();
        Person p1= new Person();
        p1.setId(2);
        p1.setName("可可西");
        p1.setAge(25);
        util.set("p1",p1);

        Person p2= new Person();
        p2.setId(3);
        p2.setName("亚索");
        p2.setAge(23);

        Person p3= new Person();
        p3.setId(4);
        p3.setName("德莱文");
        p3.setAge(27);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        util.del("persons");
        util.lSet("persons",p1);
        util.lSet("persons",p2);
        util.lSet("persons",p3);

        util.lSet("pp",list);

    }
}
