package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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

}
